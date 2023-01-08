package os_odev;

public class queues {
	queue queueFCFS=new queue();
	queue queueUJ=new queue();
	

	
	
	int FCFS_calistir(int time) {
		int sayici=0;
		String metin="";
		
		dispatcher d1 = dispatcher_create.d1;
		
		main proses=queueFCFS.queue.remove();
		
		
		metin=String.valueOf(time+sayici)+" Saniye proses basladi:         "+"PID: " +String.valueOf(proses.id) +"   Oncelik: "+ String.valueOf(proses.oncelik)+ "   Kalan Zaman: "+String.valueOf(proses.proseszamani);
		System.out.println(metin);
		
		while(proses.proseszamani!=0) {
			proses.proseszamani--;
			sayici++;
			proses.durum=time+sayici;
			if(proses.proseszamani>0) {
				metin=String.valueOf(time+sayici)+" Saniye proses yurutuluyor..    "+"PID: " +String.valueOf(proses.id) +"   Oncelik: "+ String.valueOf(proses.oncelik)+ "  Kalan Zaman: "+String.valueOf(proses.proseszamani);
				System.out.println(metin);
			}
			else {
				metin=String.valueOf(time+sayici)+" Saniye proses sonlandi:        "+"PID: " +String.valueOf(proses.id) +"   Oncelik: "+ String.valueOf(proses.oncelik)+ "  Kalan Zaman: "+String.valueOf(proses.proseszamani);
				System.out.println(metin);
			}
		}
		
		return sayici;
	}	
}
	
	

