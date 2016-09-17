package concurrent;

import java.io.*;
import java.net.Socket;
 
/**
 * �ͻ���
 */
public class Client {
	final static String SERVER_IP = "127.0.0.1";
	final static int PORT = 3333;
    public static void main(String[] args) {
 
        try {
            //1�������ͻ���Socket��ָ���������˿ںź͵�ַ
            Socket socket = new Socket(SERVER_IP,PORT);
            //2����ȡ�����,�������������Ϣ
            OutputStream os = socket.getOutputStream(); //�ֽ������
            PrintWriter pw  = new PrintWriter(os); //���������װΪ��ӡ��
            pw.write("aaabbbccc");//Ҫ���͸��������˵��ַ���
            pw.flush();
            socket.shutdownOutput(); //�ر������

            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
 
            String info = null;
            //ѭ����ȡ
            while ((info = br.readLine()) != null){
                System.out.println(info);//������������ص��ַ���
            }
 
            br.close();
            is.close();
            isr.close();
 
 
            pw.close();
            os.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}