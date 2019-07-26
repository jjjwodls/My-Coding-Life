package StringTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class GetJs {

	public static void main(String[] args) {
		System.out.println("ss");
		try {
			
			ArrayList<String> resultList = new ArrayList<String>();
			ArrayList<String> strList = readFile("C:/NANUM/workspaces/StringTest/StringTest/src/StringTest/11.txt");
			
			String str = "";
			if (strList != null) {
				int count = strList.size();
				for (int i=0; i<count; i++) {
					str = strList.get(i);
					if (str == null || str.length() == 0) {
						continue;
					}
					
					if (str.indexOf(".png") > -1) {
						System.out.println(str);
						resultList.add(str);
					}
				}
				
				writeFile("C:/NANUM/workspaces/StringTest/StringTest/src/StringTest/22.txt", resultList, false);
			}
			
			System.out.println("끝");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

/**
     * 파일 읽기
     * 
     * @param filePath
     * @return
     * @throws IOException
     * @throws Exception
     */
    public static ArrayList<String> readFile(String filePath) throws IOException, Exception {
        if (filePath == null || filePath.length() == 0) {
            return null;
        }
        
        return readFile(new File(filePath));
    }
    
    
    /**
     * 파일 읽기
     * 
     * @param file
     * @return
     * @throws IOException
     * @throws Exception
     */
    public static ArrayList<String> readFile(File file) throws IOException, Exception {
        if (file == null || !file.exists()) {
            return null;
        }
        
        ArrayList<String> resultList = null;
        
        FileInputStream fileInputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        
        try {
            fileInputStream = new FileInputStream(file);
            inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            bufferedReader = new BufferedReader(inputStreamReader);
        
            String oneLine = null;
            while ((oneLine = bufferedReader.readLine()) != null) {
                if (resultList == null) {
                    resultList = new ArrayList<String>();
                }
                
                resultList.add(oneLine);
            }

        } catch (IOException e) {
            throw e;
            
        } catch (Exception e) {
            throw e;
            
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (Exception e) {
                // 무시
            }
            
            try {
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
            } catch (Exception e) {
                // 무시
            }
            
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (Exception e) {
                // 무시
            }
        }
        
        return resultList;
    }
 








/**
     * 파일 쓰기
     * 
     * @param filePath
     * @param stringList
     * @param bAppend
     * @return
     * @throws IOException
     * @throws Exception
     */
    public static boolean writeFile(String filePath, ArrayList<String> stringList, boolean bAppend) throws IOException, Exception {
        if (filePath == null || filePath.length() == 0) {
            return false;
        }
        
        File file = new File(filePath);
        
        boolean bWrite = false;
        
        FileOutputStream fileOutputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedWriter bufferedWriter = null;
        
        try {
            fileOutputStream = new FileOutputStream(file, bAppend);
            outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-8");
            bufferedWriter = new BufferedWriter(outputStreamWriter);
        
            if (stringList != null && stringList.size() > 0) {
                String oneLine = null;
                
                int lineCount = stringList.size();
                int lastIndex = lineCount - 1;
                
                for (int i=0; i<lineCount; i++) {
                    oneLine = stringList.get(i);
                    
                    bufferedWriter.write(oneLine, 0, oneLine.length());
                    if (i < lastIndex) {
                        bufferedWriter.newLine();
                    }
                }
            }
            
            bWrite = true;
            
        } catch (IOException e) {
            throw e;
            
        } catch (Exception e) {
            throw e;
            
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            } catch (Exception e) {
                // 무시
            }
            
            try {
                if (outputStreamWriter != null) {
                    outputStreamWriter.close();
                }
            } catch (Exception e) {
                // 무시
            }
            
            try {
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (Exception e) {
                // 무시
            }
        }
        
        return bWrite;
    }

 

}
