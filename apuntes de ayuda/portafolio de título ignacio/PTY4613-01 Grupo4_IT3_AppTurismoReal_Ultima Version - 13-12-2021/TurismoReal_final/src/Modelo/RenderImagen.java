
package Modelo;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

//Metodo para listar imagen
public class RenderImagen extends DefaultTableCellRenderer{
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column){
        if (value instanceof JLabel) {
            JLabel lb1 = (JLabel) value;
            return lb1;
        }
    return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }
}
