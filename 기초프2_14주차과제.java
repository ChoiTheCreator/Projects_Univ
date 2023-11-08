package ������2_GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.io.*;
//ó�� setting��
class setting{
		String name;
		String num;
		String grade;
			public setting(String name, String num, String grade) {
				this.name = name;
				this.num = num;
				this.grade = grade;
			}
			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name=name;
			}
			
			public String getNum() {
				return num;
			}
			public void setNum(String num) {
				this.num=num;
			}
			
			public String getGrade() {
				return grade;
			}
			public void setGrade(String grade) {
				this.grade=grade;
			}
			@Override
			public String toString() {
				return "      "+getName()+"                                                        "+getNum()+"                                          "+getGrade();
			}
	}
public class ������2_14�������� extends JFrame {
	//���� Ŭ���� �Ʒ��� ����� ������Ʈ�� ��������� ����.
	JTextField t1 = new JTextField();
    JTextField t2 = new JTextField();
    JTextField t3 = new JTextField();
    JTextField t4 = new JTextField();
    JTextArea ta = new JTextArea();
    JButton btn1, btn2, btn3, btn4, btn5,btn6;
    JLabel l1 = new JLabel("�̸�:");
    JLabel l2 = new JLabel("�Ҽ��� ��:");
    JLabel l3 = new JLabel("����:");
    JLabel l4 = new JLabel("���� �˻�:");
    
    
	public ������2_14��������() {
		JFrame jframe = new JFrame();
		jframe.setBounds(50, 50, 550, 450);
		jframe.setDefaultCloseOperation(EXIT_ON_CLOSE);
		jframe.setVisible(true);
		jframe.setTitle("���� ��� ���� �ý���");
		
		
		
		JPanel jpanel = new JPanel();
		jpanel.setLayout(null);
		jframe.add(jpanel);
		
		
        
        //�̸�, �й�, ������ �����ϴ� textflied 1,2,3
		t1.setBounds(75, 25, 70, 25);
        jpanel.add(t1);
        l1.setBounds(37, 21, 70, 30);
        jpanel.add(l1);

        t2.setBounds(213, 25, 70, 25);
        jpanel.add(t2);
        l2.setBounds(150, 21, 70, 30);
        jpanel.add(l2);

        t3.setBounds(352, 25, 80, 25);
        jpanel.add(t3);
        l3.setBounds(290, 21, 70, 30);
        jpanel.add(l3);
        
        //�˻������� �˻��ϴ� textfiled 4
        t4.setBounds(213, 105, 80, 25);
        jpanel.add(t4);
        l4.setBounds(150, 100, 70, 30);
        jpanel.add(l4);
        
        

        jpanel.add(btn1 = new JButton("�Է�"));
        btn1.setBounds(40, 60, 70, 30);

        jpanel.add(btn2 = new JButton("���"));
        btn2.setBounds(145, 60, 70, 30);

        jpanel.add(btn3 = new JButton("����"));
        btn3.setBounds(250, 60, 70, 30);

        jpanel.add(btn4 = new JButton("����"));
        btn4.setBounds(350, 60, 70, 30);
        
        jpanel.add(btn5 = new JButton("����"));
        btn5.setBounds(450, 60, 70, 30);

        jpanel.add(btn6 = new JButton("�˻�"));
        btn6.setBounds(300, 100, 80, 30);
        
      //scrollpane�� textarea �κ�
        JScrollPane jsp = new JScrollPane(ta);
        jsp.setBounds(20, 145, 500, 250);
        jpanel.add(jsp);
      
        
        //�����Ҷ��� concurrentmodification������ ����	�ǽð� ������ ���� copyonwrite arraylist���
        CopyOnWriteArrayList<setting> vect = new CopyOnWriteArrayList<setting>();
        
        
        //�͸�Ŭ���� ���
        
        
        //�Է¹�ư
        btn1.addActionListener(new ActionListener() {
        	//��ư�� Ŭ��������
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		ta.setText("");
        		
        		String name = t1.getText();
        		String num = t2.getText();
        		String grade = t3.getText();
        		vect.add(new setting(name,num,grade));
        		ta.append("�Է¿Ϸ�");
        		
        		t1.setText("");
        		t2.setText("");
        		t3.setText("");
        		t4 .setText("");
        		
        	}
        });
        
        //��¹�ư
        btn2.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		ta.setText("");
        		ta.append("      �̸�                                                                  �Ҽ� ��                                           ����");
        		ta.append("\n");
        		ta.append("      ----------------------------------------------------------------------------------------------------------------------");
        		ta.append("\n");
        		for(int i=0; i<vect.size(); i++) {
        			ta.append(vect.get(i).toString()+"\n");
        		}
        		
        		t1.setText("");
        		t2.setText("");
        		t3.setText("");
        		t4 .setText("");
        	}
        });
        
        //������ư
        btn3.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		ta.setText("");
        		
        		String name = t1.getText();
        		String grade = t3.getText();
        		Iterator<setting> it = vect.iterator();
        		while(it.hasNext()) {
        			setting info = it.next();
        			if(info.getName().equals(name)) {
        				info.setGrade(grade);
        				ta.append("�����Ϸ�");
        			}
        			
        			
        		}
        		
        		
        		t1.setText("");
        		t2.setText("");
        		t3.setText("");
        		t4.setText("");
        		
        	}
        });
        
        //������ư
        btn4.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		ta.setText("");
        		int index = 0 ; 
        		
        		String num2= t1.getText();
        		Iterator<setting> it = vect.iterator();
        		
        		while(it.hasNext()) {
            		setting info2 = it.next();
            		if(info2.getName().equals(num2)) {
            			vect.remove(index);
            			ta.append("�����Ϸ�");
            		}
            		else {
            			
            		}
            		
            		
            		index ++;
            		
            	}
            	
        		
        		
        		
        		t1.setText("");
        		t2.setText("");
        		t3.setText("");
        		t4.setText("");
        	}
        });
        //�����ư
        btn5.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		ta.setText("");
        		FileWriter fw= null;
        		try {
        			fw= new FileWriter("C:\\Users\\wonbi\\Desktop\\coding\\member.txt");
        			fw.write("      �̸�                                                                  �Ҽ� ��                                           ����");
        			fw.write("\n");
        			fw.write("      ----------------------------------------------------------------------------------------------------------------------");
        			fw.write("\n");
        			for(int i=0; i<vect.size(); i++) {
        				fw.write(vect.get(i).toString()+"\n");
        			}
        			ta.append("����Ϸ�:member.txt");
        			
        			
        			fw.close();
        		
        		}
        		
        		catch(IOException error) {
        			System.out.println("��� ����");
        		}
        	}
        });
        
       //�˻� ��ư
        btn6.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		ta.setText("");
        		
        		ta.append("      �̸�                                                                  �Ҽ� ��                                           ����");
        		ta.append("\n");
        		ta.append("      ----------------------------------------------------------------------------------------------------------------------");
        		ta.append("\n");
        		String search = t4.getText();
        		
        		Iterator<setting> it = vect.iterator();
        		
        		
        		while(it.hasNext()) {
        			setting info = it.next();
        			if(info.getName().equals(search)) {
        				ta.append(info.toString());
        			}
        			
        			
        		}
        		
        	}
        });
	}
	
	
	
		
		

	public static void main(String[] args) {
		new ������2_14��������();

	}

}
