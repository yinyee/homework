package currencyconverter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

// Reference: https://docs.oracle.com/javase/tutorial/uiswing/components/combobox.html
public class ComboBoxCurrencies implements ActionListener {
	
	public ComboBoxCurrencies(){
		;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JComboBox<String> combobox = (JComboBox<String>) e.getSource();
		String selectedCurrency = (String) combobox.getSelectedItem();
	}
	

}
