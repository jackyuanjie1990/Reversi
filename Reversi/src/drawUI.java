import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class drawUI extends JFrame {
    
	public static void print(Reversi game, JPanel panel) {
		for (int y = 0; y < 8; y++) {
	    	   for (int x = 0; x < 8; x++) {
	    		   JLabel pieces = new JLabel(); 
	    		   if (game.board[y][x] == 0) {
	    			   pieces.setIcon(new ImageIcon("graph/empty.jpg"));
	        	       panel.add(pieces, 0);
	    		   }
	    		   if (game.board[y][x] == -1) {
	    			   pieces.setIcon(new ImageIcon("graph/black.jpg"));
	        	       panel.add(pieces, 0);
	    		   }
	    		   if (game.board[y][x] == 1) {
	    			   pieces.setIcon(new ImageIcon("graph/white.jpg"));
	        	       panel.add(pieces, 0);
	    		   }
	    	       Dimension size_p = pieces.getPreferredSize();
	    	       pieces.setBounds(26 + x * 37, 26 + y * 37, size_p.width, size_p.height);
	    	   }
		}	
	}

   public static void main(String[] args) {
       JFrame frame=new JFrame("Reversi");  //title
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setSize(400,400);
       frame.setVisible(true);
       
       JPanel panel = (JPanel)frame.getContentPane();  
       panel.setLayout(null);

       JLabel label = new JLabel();  
       label.setIcon(new ImageIcon("graph/board.jpg"));
       panel.add(label, -1);
       Dimension size = label.getPreferredSize();
       label.setBounds(0, 0, size.width, size.height);
  
       Reversi game = new Reversi();
       for (int y = 0; y < 8; y++) {
    	   for (int x = 0; x < 8; x++) {
    		   JLabel pieces = new JLabel(); 
    		   if (game.board[y][x] == 0) {
    			   pieces.setIcon(new ImageIcon("graph/empty.jpg"));
        	       panel.add(pieces, 0);
    		   }
    		   if (game.board[y][x] == -1) {
    			   pieces.setIcon(new ImageIcon("graph/black.jpg"));
        	       panel.add(pieces, 0);
    		   }
    		   if (game.board[y][x] == 1) {
    			   pieces.setIcon(new ImageIcon("graph/white.jpg"));
        	       panel.add(pieces, 0);
    		   }
    	       Dimension size_p = pieces.getPreferredSize();
    	       pieces.setBounds(26 + x * 37, 26 + y * 37, size_p.width, size_p.height);
    	       String s = "" + (y * 8 + x);
    	       pieces.setText(s);
    	       pieces.addMouseListener(new MouseAdapter()
    			 {
    		    public void mouseClicked(MouseEvent e) {
//    		    	System.out.println("Hello");
//    		    	System.out.println("x is : " + pieces.getText());
//    		    	ImageIcon image2 = new ImageIcon("graph/white.jpg");
//    		    	pieces.setIcon(image2);
    		    	game.printPlayerMove(pieces.getText());
    		    	print(game, panel);
    		    	game.AIreaction();
    		    	//print(game, panel);
    		    
    		    	
    		    }
    		});
    	   }
       }
    
       }

}
