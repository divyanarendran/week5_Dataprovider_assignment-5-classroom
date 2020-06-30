	package week5_Dataprovider_assignmen5_classrooom;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadXcel {


		public  static String[][] readData(String workbookname) throws IOException{
			// TODO Auto-generated method stub
			
			XSSFWorkbook wb= new XSSFWorkbook("./data/"+workbookname+".xlsx");
			XSSFSheet ws= wb.getSheetAt(0);
			//to get row count
			int rowscount= ws.getLastRowNum();
			System.out.println(rowscount);
			//to get column count
			int cellscount= ws.getRow(0).getLastCellNum();
			System.out.println(cellscount);
			String [][] data=new String [rowscount][cellscount];
			//to print all the values in cell
			for(int i=1;i<=rowscount;i++)
			{
				for(int j=0;j<cellscount;j++)
				{
					String cellvalue=ws.getRow(i).getCell(j).getStringCellValue();
				   data[i-1][j]=cellvalue;
				   
				}
					
			}
			wb.close();
			return data;
		}


	}


