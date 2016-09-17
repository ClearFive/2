package concurrent;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
 
/**
 * ����TCPЭ���Socketͨ�ţ�ʵ���û���¼
 * ��������
 */
public class Server {
 
    public static void main(String[] args) {
    	final String SERVER_IP = "127.0.0.1";
    	final int PORT = 3333;
        try {
            //1������һ����������Socket,��ServerSocket, ָ���󶨵Ķ˿ڣ��������˶˿�
            ServerSocket serverSocket = new ServerSocket(PORT, 10, InetAddress.getByName(SERVER_IP) );
            Socket socket = null;
            //��¼�ͻ��˵�����
            int count = 0;
            System.out.println("���������������ȴ��ͻ��˵����ӡ�");
            //ѭ�������ȴ��ͻ��˵�����
            while (true){
                //����accept()������ʼ�������ȴ��ͻ��˵�����
                socket = serverSocket.accept();
                //����һ���µ��߳�
                ServerThread serverThread = new ServerThread(socket);
                //�����߳�
                serverThread.start();
 
                count++; //ͳ�ƿͻ��˵�����
               // System.out.println("�ͻ��˵�����: " + count);
                InetAddress address = socket.getInetAddress();
                //System.out.println("��ǰ�ͻ��˵�IP �� " + address.getHostAddress());
            }
 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

