import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Program extends JFrame {

    private List<Beverage> beverageList = new ArrayList<>();

    public Program() {
        createMainPanel();
        setSize(400, 400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * creates main panel
     */
    private void createMainPanel() {
        JPanel mainPanel = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        mainPanel.setLayout(layout);

        JLabel lblSelectSize = new JLabel("Select size:");
        JComboBox<String> cbSize = new JComboBox<>(new String[]{"Small", "Medium", "Large"});
        mainPanel.add(lblSelectSize, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
        mainPanel.add(cbSize, new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.BASELINE_LEADING, GridBagConstraints.BASELINE_LEADING, new Insets(5, 5, 5, 5), 0, 0));

        JLabel lblType = new JLabel("Select the type of beverage you want to order:");
        JRadioButton rbJuice = new JRadioButton("Juice");
        JRadioButton rbWater = new JRadioButton("Water");
        JRadioButton rbTea = new JRadioButton("Tea");
        JRadioButton rbCoffee = new JRadioButton("Coffee");
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbJuice);
        bg.add(rbWater);
        bg.add(rbTea);
        bg.add(rbCoffee);
        JPanel pnlType = new JPanel();
        BoxLayout layoutType = new BoxLayout(pnlType, BoxLayout.X_AXIS);
        pnlType.setLayout(layoutType);
        pnlType.add(rbJuice);
        pnlType.add(rbWater);
        pnlType.add(rbTea);
        pnlType.add(rbCoffee);
        mainPanel.add(lblType, new GridBagConstraints(0, 2, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
        mainPanel.add(pnlType, new GridBagConstraints(0, 3, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));

        JLabel lblGlassCount = new JLabel("Select how many glasses you want to order:");
        JTextField tfCount = new JTextField();
        mainPanel.add(lblGlassCount, new GridBagConstraints(0, 4, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
        mainPanel.add(tfCount, new GridBagConstraints(0, 5, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));

        /**
         * buttons
         */
        JButton btnAdd = new JButton("Add");
        JButton btnOrder = new JButton("Order");
        mainPanel.add(btnAdd, new GridBagConstraints(0, 6, 1, 1, 1, 1, GridBagConstraints.LINE_START, GridBagConstraints.BASELINE_LEADING, new Insets(5, 5, 5, 5), 70, 40));
        mainPanel.add(btnOrder, new GridBagConstraints(0, 6, 1, 1, 1, 1, GridBagConstraints.LINE_END, GridBagConstraints.BASELINE_LEADING, new Insets(5, 5, 5, 5), 70, 40));

        JLabel tfInfo = new JLabel();
        mainPanel.add(tfInfo, new GridBagConstraints(0, 7, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));


        setContentPane(mainPanel);
        /**
         * when add button press this function works
         */
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /**
                 * check glasses count is number
                 */
                try {
                    Integer.parseInt(tfCount.getText());
                    Beverage beverage = null;
                    if (bg.getSelection() == null || tfCount.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(Program.this, "Choose a beverage type and  enter an amount.");
                        return;
                    } else if (rbJuice.isSelected()) {
                        String juiceType = showJuiceCatolog();

                        beverage = new Juice(cbSize.getSelectedItem().toString(), tfCount.getText(), juiceType);
                        beverageList.add(beverage);
                        tfInfo.setText(beverage.toString());
                    } else if (rbWater.isSelected()) {
                        int dialogResult = JOptionPane.showConfirmDialog(null, "Would You Like ice?", "Warning", JOptionPane.YES_NO_OPTION);
                        if (dialogResult == JOptionPane.YES_OPTION) {
                            beverage = new Water(cbSize.getSelectedItem().toString(), tfCount.getText(), true);
                        } else {
                            beverage = new Water(cbSize.getSelectedItem().toString(), tfCount.getText(), false);
                        }
                        beverageList.add(beverage);
                        tfInfo.setText(beverage.toString());
                    } else if (rbTea.isSelected()) {
                        int dialogResult = JOptionPane.showConfirmDialog(null, "Would You Like sugar?", "Warning", JOptionPane.YES_NO_OPTION);
                        if (dialogResult == JOptionPane.YES_OPTION) {
                            beverage = new Tea(cbSize.getSelectedItem().toString(), tfCount.getText(), true);
                        } else {
                            beverage = new Tea(cbSize.getSelectedItem().toString(), tfCount.getText(), false);
                        }
                        beverageList.add(beverage);
                        tfInfo.setText(beverage.toString());
                    } else if (rbCoffee.isSelected()) {
                        int dialogResult = JOptionPane.showConfirmDialog(null, "Would You Like milk?", "Warning", JOptionPane.YES_NO_OPTION);
                        if (dialogResult == JOptionPane.YES_OPTION) {
                            beverage = new Coffee(cbSize.getSelectedItem().toString(), tfCount.getText(), true);
                        } else {
                            beverage = new Coffee(cbSize.getSelectedItem().toString(), tfCount.getText(), false);
                        }
                        beverageList.add(beverage);
                    }
                    tfInfo.setText(beverage.getCount() + " glass(es) of " + beverage.toString() + " added.");

                    /**
                     * clears selections
                     */
                    bg.clearSelection();
                    tfCount.setText("");

                } catch (NumberFormatException | NullPointerException nfe) {
                    JOptionPane.showMessageDialog(Program.this, "You must enter a number!!");
                }
            }
        });

        /**
         * when add button press this function works
         */
        btnOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (beverageList.size() < 1) {
                    JOptionPane.showMessageDialog(Program.this, "There is no order in list!!");
                } else {
                    JPanel panel = new JPanel();
                    BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
                    panel.setLayout(boxLayout);

                    int price = 0;
                    /**
                     * shows list of orders in message dialog
                     */
                    for (int i = 0; i < beverageList.size(); i++) {
                        Beverage beverage = beverageList.get(i);

                        JLabel label = new JLabel(beverage.toString() + "\t-\t" + beverage.getPrice() + " TL");
                        panel.add(label);

                        price += beverage.getPrice();
                    }
                    /**
                     * show list of orders then show price
                     */
                    JOptionPane.showMessageDialog(Program.this, panel, "Message", JOptionPane.QUESTION_MESSAGE);
                    JOptionPane.showMessageDialog(Program.this, "You should pay " + price + " TL.");
                    beverageList.clear(); // empthy list because order is complated
                }
            }
        });
    }

    /**
     * opens a dialog to show juice type
     *
     * @return
     */
    private String showJuiceCatolog() {
        String[] juiceTypes = {"Apple", "Orange", "Pineapple"};
        JComboBox<String> cbJuiceTypes = new JComboBox<>(juiceTypes);

        JOptionPane.showMessageDialog(this, cbJuiceTypes, "Select a fruid.", JOptionPane.QUESTION_MESSAGE);
        return cbJuiceTypes.getSelectedItem().toString();
    }

    public static void main(String[] args) {
        new Program();
    }
}
