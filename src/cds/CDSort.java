package cds;

import util.ReadTextFile;
import pqsort.PQSort;
import java.util.ArrayList;
import java.util.Iterator;
import util.KeyedItem;

public class CDSort
{
   public static void main (String[] args)
   {
	   String file_name = "cds.txt";
	  
	   //DO THIS
	   //use pq sort on the array of cds
	   //print out the cds showing sorted order by title
	   CD[] unsorted_cds = readMusic(file_name);
	   int size = unsorted_cds.length;
	
	   PQSort<CD> pq_sort = new PQSort<CD>();
	   CD[] sorted_cds = pq_sort.pqSort(unsorted_cds, false);
	   
	   for (int i = 1; i <= size; i++)
	   {
		   CD cd = sorted_cds[i - 1];
		   System.out.println(cd);
	   }
   }

   private static CD[] readMusic(String file_name)
   {
	   ArrayList<CD> cds = new ArrayList<CD>();
	   
      ReadTextFile file = new ReadTextFile(file_name);
      String str = file.readLine();
      while (!file.EOF())
      {
         String title = file.readLine();
         int year = Integer.parseInt(file.readLine());
         int rating = Integer.parseInt(file.readLine());
         int numTracks = Integer.parseInt(file.readLine());
         CD cd = new CD(title, str, year, rating, numTracks);

         cds.add(cd);
         int tracks = 1;

         while (tracks <= numTracks)
         {
            String temp = file.readLine();
            String[] line = temp.split(",");
            String len = line[0];
            String songTitle = line[1];
            Song song = new Song(songTitle, len);
            cd.addSong(song);
            tracks++;
         }

         str = file.readLine();
      }
	  
	  int num_cds = cds.size();
	  CD[] cd_array = new CD[num_cds];
	  
	  int count = 0;
	  for (CD cd : cds)
	  {
		  cd_array[count] = cd;
		  count++;
	  }
	  
	  return cd_array;
   }
}