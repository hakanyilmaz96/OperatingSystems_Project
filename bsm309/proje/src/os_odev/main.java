package os_odev;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


//Proses sınıfı main classı altında oluşturuldu

public class main {
	int id;
	int variszamani;
	int oncelik;
	int proseszamani;
	int durum;
	dispatcher d1 = new dispatcher();
	int pid=0;
	public void ProsesOlusturucu() throws IOException{
		
		List<String> text = Files.readAllLines(Paths.get("./text/giris.txt"));
		
		
		for(int i=0; i<text.size();i++) {
			
			String line = text.get(i);
			
			main main = new main();
			
			int index = -1;
			
			String processbilgi="";
			
			for (int j=0; j < line.length(); j++) {
				
				char ind = line.charAt(j);
				
				if(ind ==' ')
					continue;
				else if (j == line.length()-1 ){
					
					processbilgi += ind;	
					main.proseszamani = Integer.parseInt(processbilgi);
				}		
				else if (ind != ',' ){
					
					processbilgi += ind;	
					
				}	
				else {	
					
					index++;
					switch (index) {
					case 0:
						main.variszamani = Integer.parseInt(processbilgi);
						durum=variszamani;
						break;
					case 1:
						main.oncelik = Integer.parseInt(processbilgi);
						break;
				}
					processbilgi="";
				}
			}
			
			main.id=pid;
			pid++;
			
			d1.dispatcher.add(main);
			
		}
		d1.processDispatcher();
	}
	public static void main(String[] args) throws IOException {

		main proses = new main();
		
		proses.ProsesOlusturucu();

}
}
