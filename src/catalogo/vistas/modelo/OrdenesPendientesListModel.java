package catalogo.vistas.modelo;

import catalogo.controladores.JPA.OrdenDeCompraJpaController;
import catalogo.modelo.OrdenCompra;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.AbstractListModel;

/**
 *
 * @author Mauro Federico Lopez
 */
public class OrdenesPendientesListModel extends AbstractListModel implements Observer {

    private OrdenDeCompraJpaController ordenDeCompraJpaController;
    private ArrayList<OrdenCompra> ordenesPendientes;

    public OrdenesPendientesListModel(OrdenDeCompraJpaController ordenDeCompraJpaController) {
        super();
        this.ordenDeCompraJpaController = ordenDeCompraJpaController;
        this.ordenDeCompraJpaController.addObserver(this);
        ordenesPendientes = ordenDeCompraJpaController.obtenerOrdenesDeCompraPendientes();
    }

    @Override
    public int getSize() {
        return ordenesPendientes.size();
    }

    @Override
    public Object getElementAt(int index) {
        return ordenesPendientes.get(index);
    }

    @Override
    public void update(Observable o, Object arg) {
        ordenesPendientes = ordenDeCompraJpaController.obtenerOrdenesDeCompraPendientes();
        fireContentsChanged(this, -1, ordenesPendientes.size());
    }

}
