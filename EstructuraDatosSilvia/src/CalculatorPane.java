import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class CalculatorPane extends JFrame{

	protected JTextField inputField;
	protected JButton ceBtn, leftPBtn, rightPBtn, changeSignBtn;
	protected JButton sevenBtn, eightBtn, nineBtn, divBtn;
	protected JButton fourBtn, fiveBtn, sixBtn, multBtn;
	protected JButton oneBtn, twoBtn, threeBtn, subsBtn;
	protected JButton zeroBtn, pointBtn, equalBtn, sumBtn;
	protected JPanel rootPane, calcPane;
	protected Border border;
	
	public CalculatorPane() {
		super("Calculadora");
		
		rootPane = new JPanel();
		BoxLayout layout = new BoxLayout(rootPane, BoxLayout.Y_AXIS);
		rootPane.setLayout(layout);
		
		calcPane = new JPanel(new GridLayout(5, 4));
		border = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		rootPane.setBorder(border);
		
		//Buttons Panel
		leftPBtn = new JButton("(");
		calcPane.add(leftPBtn);
		rightPBtn = new JButton(")");
		calcPane.add(rightPBtn);
		ceBtn = new JButton("DEL");
		calcPane.add(ceBtn);
		changeSignBtn = new JButton("AC");
		calcPane.add(changeSignBtn);
		
		sevenBtn = new JButton("7");
		calcPane.add(sevenBtn);
		eightBtn = new JButton("8");
		calcPane.add(eightBtn);
		nineBtn = new JButton("9");
		calcPane.add(nineBtn);
		divBtn = new JButton("/");
		calcPane.add(divBtn);
		
		fourBtn = new JButton("4");
		calcPane.add(fourBtn);
		fiveBtn = new JButton("5");
		calcPane.add(fiveBtn);
		sixBtn = new JButton("6");
		calcPane.add(sixBtn);
		multBtn = new JButton("*");
		calcPane.add(multBtn);
		
		oneBtn = new JButton("1");
		calcPane.add(oneBtn);
		twoBtn = new JButton("2");
		calcPane.add(twoBtn);
		threeBtn = new JButton("3");
		calcPane.add(threeBtn);
		subsBtn = new JButton("-");
		calcPane.add(subsBtn);
		
		zeroBtn = new JButton("0");
		calcPane.add(zeroBtn);
		pointBtn = new JButton(".");
		calcPane.add(pointBtn);
		equalBtn = new JButton("=");
		calcPane.add(equalBtn);
		sumBtn = new JButton("+");
		calcPane.add(sumBtn);
		
		inputField = new JTextField();
		inputField.setEditable(false);
		
		rootPane.add(inputField);
		rootPane.add(calcPane);
		
		super.add(rootPane);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}

}
