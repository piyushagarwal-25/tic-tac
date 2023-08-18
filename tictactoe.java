import java.awt.event.*
import java.awt.*;
import javax.swing.*;
import java.util.*;
public class tictactoe implements ActionListener {
	static JFrame f;
	static JButton  B1,B2,B3,B4,B5,B6,B7,B8,B9,start;
	static JLabel l;
	String s;
	static boolean p=false;
	static JLabel l2=new JLabel("");
	static ArrayList <JButton> arr;
	static ArrayList <JButton> arr1;
	static ArrayList <JButton> store;
	static String board[]=new String[9];
	static JPanel p5;
	static void check_winner(){
		int b=0;
		for (int a = 0; a < 8; a++) {
            String line = null;
 
            switch (a) {
            case 0:
                line = board[0] + board[1] + board[2];
                break;
            case 1:
                line = board[3] + board[4] + board[5];
                break;
            case 2:
                line = board[6] + board[7] + board[8];
                break;
            case 3:
                line = board[0] + board[3] + board[6];
                break;
            case 4:
                line = board[1] + board[4] + board[7];
                break;
            case 5:
                line = board[2] + board[5] + board[8];
                break;
            case 6:
                line = board[0] + board[4] + board[8];
                break;
            case 7:
                line = board[2] + board[4] + board[6];
                break;
            }
            //For X winner
            if (line.equals("XXX")) {
				l2.setText("Player 1 Won!!");
				l2.setFont(new Font("X",Font.PLAIN,80));
				p=false;
				b++;
				for(int i=0;i<9;i++){
					board[i]="";
				}
            }
             
            // For O winner
            else if (line.equals("OOO")) {
				l2.setText("Player 2 Won!!");
				l2.setFont(new Font("X",Font.PLAIN,80));
				p=false;
				b++;
				for(int j=0;j<9;j++){
					board[j]="";
				}
            }
			
        }
		if(arr.isEmpty()==true && b==0){
			l2.setText("Its a Tie");
			l2.setFont(new Font("X",Font.PLAIN,80));
			for(int k=0;k<9;k++){
				board[k]="";
			}
		}		
	}
		
	
	public static void main(String args[]){
		tictactoe a=new tictactoe();
		f=new JFrame("TIC TAC TOE");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(800,850);
		JPanel p1=new JPanel();
		JPanel p2=new JPanel();
		JPanel p3=new JPanel();
		JPanel p4=new JPanel();
		p5=new JPanel();
		p1.setBackground(Color.red);
		Dimension size=f.getSize();
		p1.setBounds(0,0,800,200);
		JLabel l1=new JLabel("TIC TAC TOE");
		l1.setBounds(150,0,600,100);
		l1.setFont(new Font("X",Font.PLAIN,80));
		//p1.setLayout(new FlowLayout(FlowLayout.LEFT));
		p1.add(l1);
		p2.setBounds(200,200,400,400);
		p2.setLayout(new GridLayout(3,3));
		B1=new JButton("");
		B2=new JButton("");
		B3=new JButton("");
		B4=new JButton("");
		B5=new JButton("");
		B6=new JButton("");
	    B7=new JButton("");
		B8=new JButton("");
	    B9=new JButton("");
		B1.addActionListener(a);
		B2.addActionListener(a);
	    B3.addActionListener(a);
		B4.addActionListener(a);
		B5.addActionListener(a);
	    B6.addActionListener(a);
		B7.addActionListener(a);
		B8.addActionListener(a);
		B9.addActionListener(a);
		p2.add(B1);
		p2.add(B2);
		p2.add(B3);
		p2.add(B4);
	    p2.add(B5);
		p2.add(B6);
	    p2.add(B7);
		p2.add(B8);
		p2.add(B9);
		arr=new ArrayList<JButton>();
		store=new ArrayList<JButton>();
		arr.add(B1);
		arr.add(B2);
		arr.add(B3);
		arr.add(B4);
		arr.add(B5);
		arr.add(B6);
		arr.add(B7);
		arr.add(B8);
		arr.add(B9);
		arr1=new ArrayList<JButton>();
		arr1.add(B1);
		arr1.add(B2);
		arr1.add(B3);
		arr1.add(B4);
		arr1.add(B5);
		arr1.add(B6);
		arr1.add(B7);
		arr1.add(B8);
		arr1.add(B9);
		
		p3.setBackground(Color.orange);
		p3.setBounds(0,200,200,400);
		p4.setBackground(Color.orange);
		p4.setBounds(600,200,200,400);
		start =new JButton("New Game");
		start.setBounds(200,150,400,50);
		start.setFont(new Font("c",Font.PLAIN,30));
		p1.setLayout(null);
		start.addActionListener(a);
		p1.add(start);
		p5.setBackground(Color.blue);
		p5.setBounds(0,600,800,200);
		p5.add(l2);
		f.add(p1);
		f.add(p2);
		f.add(p3);
		f.add(p4);
		f.add(p5);
		f.setLayout(null);
		f.setVisible(true);
	}
	public void actionPerformed(ActionEvent g){
		JButton b=(JButton)g.getSource();
		if(b==start){
			p=true;
			s="X";
			l2.setText("");
			B1.setText("");
			B2.setText("");
			B3.setText("");
			B4.setText("");
			B5.setText("");
			B6.setText("");
			B7.setText("");
			B8.setText("");
			B9.setText("");
			arr.addAll(store);
			store.removeAll(arr);
		}
		if(p){
			if(arr.contains(b)){
				b.setFont(new Font("X",Font.PLAIN,80));
				b.setText(s);
				int q=arr1.indexOf(b);
				board[q]=s;
				arr.remove(b);
				check_winner();
				store.add(b);
				if(s=="X"){
					s="O";
				}
				else if(s=="O"){
					s="X";
				}
			
			}
		}
	}
}
