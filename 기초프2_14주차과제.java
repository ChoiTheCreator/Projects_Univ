package 기초프2_GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.io.*;
//처음 setting값
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
public class 기초프2_14주차과제 extends JFrame {
	//먼저 클래스 아래에 사용할 컴포넌트를 가짓수대로 저장.
	JTextField t1 = new JTextField();
    JTextField t2 = new JTextField();
    JTextField t3 = new JTextField();
    JTextField t4 = new JTextField();
    JTextArea ta = new JTextArea();
    JButton btn1, btn2, btn3, btn4, btn5,btn6;
    JLabel l1 = new JLabel("이름:");
    JLabel l2 = new JLabel("소속팀 명:");
    JLabel l3 = new JLabel("성적:");
    JLabel l4 = new JLabel("선수 검색:");
    
    
	public 기초프2_14주차과제() {
		JFrame jframe = new JFrame();
		jframe.setBounds(50, 50, 550, 450);
		jframe.setDefaultCloseOperation(EXIT_ON_CLOSE);
		jframe.setVisible(true);
		jframe.setTitle("선수 명단 관리 시스템");
		
		
		
		JPanel jpanel = new JPanel();
		jpanel.setLayout(null);
		jframe.add(jpanel);
		
		
        
        //이름, 학번, 성적을 기입하는 textflied 1,2,3
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
        
        //검색내용을 검색하는 textfiled 4
        t4.setBounds(213, 105, 80, 25);
        jpanel.add(t4);
        l4.setBounds(150, 100, 70, 30);
        jpanel.add(l4);
        
        

        jpanel.add(btn1 = new JButton("입력"));
        btn1.setBounds(40, 60, 70, 30);

        jpanel.add(btn2 = new JButton("출력"));
        btn2.setBounds(145, 60, 70, 30);

        jpanel.add(btn3 = new JButton("수정"));
        btn3.setBounds(250, 60, 70, 30);

        jpanel.add(btn4 = new JButton("삭제"));
        btn4.setBounds(350, 60, 70, 30);
        
        jpanel.add(btn5 = new JButton("저장"));
        btn5.setBounds(450, 60, 70, 30);

        jpanel.add(btn6 = new JButton("검색"));
        btn6.setBounds(300, 100, 80, 30);
        
      //scrollpane과 textarea 부분
        JScrollPane jsp = new JScrollPane(ta);
        jsp.setBounds(20, 145, 500, 250);
        jpanel.add(jsp);
      
        
        //삭제할때의 concurrentmodification방지를 위해	실시간 변경을 위해 copyonwrite arraylist사용
        CopyOnWriteArrayList<setting> vect = new CopyOnWriteArrayList<setting>();
        
        
        //익명클래스 사용
        
        
        //입력버튼
        btn1.addActionListener(new ActionListener() {
        	//버튼이 클릭됐을때
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		ta.setText("");
        		
        		String name = t1.getText();
        		String num = t2.getText();
        		String grade = t3.getText();
        		vect.add(new setting(name,num,grade));
        		ta.append("입력완료");
        		
        		t1.setText("");
        		t2.setText("");
        		t3.setText("");
        		t4 .setText("");
        		
        	}
        });
        
        //출력버튼
        btn2.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		ta.setText("");
        		ta.append("      이름                                                                  소속 팀                                           성적");
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
        
        //수정버튼
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
        				ta.append("수정완료");
        			}
        			
        			
        		}
        		
        		
        		t1.setText("");
        		t2.setText("");
        		t3.setText("");
        		t4.setText("");
        		
        	}
        });
        
        //삭제버튼
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
            			ta.append("삭제완료");
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
        //저장버튼
        btn5.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		ta.setText("");
        		FileWriter fw= null;
        		try {
        			fw= new FileWriter("C:\\Users\\wonbi\\Desktop\\coding\\member.txt");
        			fw.write("      이름                                                                  소속 팀                                           성적");
        			fw.write("\n");
        			fw.write("      ----------------------------------------------------------------------------------------------------------------------");
        			fw.write("\n");
        			for(int i=0; i<vect.size(); i++) {
        				fw.write(vect.get(i).toString()+"\n");
        			}
        			ta.append("저장완료:member.txt");
        			
        			
        			fw.close();
        		
        		}
        		
        		catch(IOException error) {
        			System.out.println("출력 오류");
        		}
        	}
        });
        
       //검색 버튼
        btn6.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		ta.setText("");
        		
        		ta.append("      이름                                                                  소속 팀                                           성적");
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
		new 기초프2_14주차과제();

	}

}
