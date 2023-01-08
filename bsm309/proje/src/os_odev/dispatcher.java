package os_odev;
import java.util.LinkedList;


//Dispatcher classı oluşturuldu fonksiyonlar ayarlandı

public class dispatcher {
	
	LinkedList<main> dispatcher;
	
	public dispatcher() {		
		dispatcher = new LinkedList<main>();
	}

	
	queues queues = new queues();
	lists lists= new lists();

	
	int sayici=0;	
	
	public void processDispatcher() {
		
		int boyut = dispatcher.size();
		
		int processSayisi = 0;
		
		
		while (processSayisi != boyut*2 ) {
			
			for(int i =0; i < boyut ;i++) {
				if(dispatcher.size()==0)
					break;
				if(dispatcher.get(0).variszamani>sayici)
					break;
				else if(dispatcher.get(0).oncelik == 0 || dispatcher.get(0).oncelik == 1 || dispatcher.get(0).oncelik == 2 || dispatcher.get(0).oncelik == 3) {
					queues.queueFCFS.queue.add(dispatcher.remove());
					processSayisi++;
					
				}		
			}		
			
			if (!(queues.queueFCFS.queue.isEmpty())) { 
				
				int rt_timer = queues.FCFS_calistir(sayici);
				sayici += rt_timer;			
			}
				
		}
	
	}
}