package os_odev;

import java.util.LinkedList;


public class lists {
	queue queueRR=new queue();
	queue queueFPL=new queue();
	queue queueSPL=new queue();
	int sayac=0;
	main cikanEleman = null;
	int RoundRobin_calistir(int time) {
		int sayici=0;
		String metin="";
		dispatcher dispatcher = dispatcher_create.d1;
		main proses=queueRR.queue.get(sayac);
		metin=String.valueOf(time+sayici)+" Saniye proses basladi:        "+"PID: " +String.valueOf(proses.id) +"   Oncelik: "+ String.valueOf(proses.oncelik)+ "  Kalan Zaman: "+String.valueOf(proses.proseszamani);
		System.out.println(metin);
		sayici ++;
		proses.proseszamani--;
		proses.durum=time+sayici;
	
		if(proses.proseszamani==0) {
			metin=String.valueOf(time+sayici)+" Saniye proses sonlandi:        "+"PID: " +String.valueOf(proses.id) +"   Oncelik: "+ String.valueOf(proses.oncelik)+ "  Kalan Zaman: "+String.valueOf(proses.proseszamani);
			System.out.println(metin);
			queueRR.queue.remove();
			if(sayac==queueRR.queue.size())
				sayac=0;
		}
		else {
			metin=String.valueOf(time+sayici)+" Saniye proses askida:        "+"PID: " +String.valueOf(proses.id) +"   Oncelik: "+ String.valueOf(proses.oncelik)+ "  Kalan Zaman: "+String.valueOf(proses.proseszamani);
			System.out.println(metin);
			sayac=(sayac+1)%queueRR.queue.size();
		}
		return sayici;
		
		
	}

	int FPL_calistir(int time) {
		int sayici =0;
		String metin="";
		dispatcher dispatcher = dispatcher_create.d1;
		main proses=queueFPL.queue.remove();
		metin=String.valueOf(time+sayici)+" Saniye proses basladi:        "+"PID: " +String.valueOf(proses.id) +"   Oncelik: "+ String.valueOf(proses.oncelik)+ "  Kalan Zaman: "+String.valueOf(proses.proseszamani);
		System.out.println(metin);
		sayici++;
		proses.proseszamani--;
		
		proses.durum=time+sayici;
		
		if(proses.proseszamani>0) {
			proses.oncelik++;
			
			metin=String.valueOf(time+sayici)+" Saniye proses askida:        "+"PID: " +String.valueOf(proses.id) +"   Oncelik: "+ String.valueOf(proses.oncelik)+ "  Kalan Zaman: "+String.valueOf(proses.proseszamani);
			System.out.println(metin);
			
			queueSPL.queue.add(proses);
		}
		
		else {
			metin=String.valueOf(time+sayici)+" Saniye proses sonlandi:        "+"PID: " +String.valueOf(proses.id) +"   Oncelik: "+ String.valueOf(proses.oncelik)+ "  Kalan Zaman: "+String.valueOf(proses.proseszamani);
			System.out.println(metin);
		}		
		return sayici;
	}
	
	int SPL_calistir(int time){
	
		int sayici=0;
		String metin="";
		dispatcher dispatcher = dispatcher_create.d1;
		main proses = queueSPL.queue.remove();
		
		metin=String.valueOf(time+sayici)+" Saniye proses basladi:        "+"PID: " +String.valueOf(proses.id) +"   Oncelik: "+ String.valueOf(proses.oncelik)+ "  Kalan Zaman: "+String.valueOf(proses.proseszamani);
		System.out.println(metin);
		
		sayici++;
		proses.proseszamani--;
		proses.durum=time+sayici;
		
		if (proses.proseszamani > 0) { 

			proses.oncelik++;

			queueRR.queue.add(proses);
			metin=String.valueOf(time+sayici)+" Saniye proses askida:        "+"PID: " +String.valueOf(proses.id) +"   Oncelik: "+ String.valueOf(proses.oncelik)+ "  Kalan Zaman: "+String.valueOf(proses.proseszamani);
			System.out.println(metin);

		} 
		
		else {
			metin=String.valueOf(time+sayici)+" Saniye proses sonlandi:        "+"PID: " +String.valueOf(proses.id) +"   Oncelik: "+ String.valueOf(proses.oncelik)+ "  Kalan Zaman: "+String.valueOf(proses.proseszamani);
			System.out.println(metin);
		}
		
		return sayici;
	}
	
}
