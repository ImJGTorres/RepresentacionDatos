package Control;

import Modelo.Conversiones;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

/**
 *
 * @author Gabriel Torres & Emerson Vera
 */
/**
 * Sample Skeleton for 'RepresentacionDatos.fxml' Controller Class
 */
public class RepresentacionDatosController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="chUnidadNumero"
    private ChoiceBox<String> chUnidadNumero; // Value injected by FXMLLoader

    @FXML // fx:id="chUnidadResultado"
    private ChoiceBox<String> chUnidadResultado; // Value injected by FXMLLoader

    @FXML // fx:id="cmdConvertirCualquiera"
    private Button cmdConvertirCualquiera; // Value injected by FXMLLoader

    @FXML // fx:id="cmdConvertirIEC"
    private Button cmdConvertirIEC; // Value injected by FXMLLoader

    @FXML // fx:id="cmdConvertirSI"
    private Button cmdConvertirSI; // Value injected by FXMLLoader

    @FXML // fx:id="txtGB"
    private TextField txtGB; // Value injected by FXMLLoader

    @FXML // fx:id="txtGiB"
    private TextField txtGiB; // Value injected by FXMLLoader

    @FXML // fx:id="txtKB"
    private TextField txtKB; // Value injected by FXMLLoader

    @FXML // fx:id="txtKiB"
    private TextField txtKiB; // Value injected by FXMLLoader

    @FXML // fx:id="txtMB"
    private TextField txtMB; // Value injected by FXMLLoader

    @FXML // fx:id="txtMiB"
    private TextField txtMiB; // Value injected by FXMLLoader

    @FXML // fx:id="txtNumeroBytesIEC"
    private TextField txtNumeroBytesIEC; // Value injected by FXMLLoader

    @FXML // fx:id="txtNumeroBytesSI"
    private TextField txtNumeroBytesSI; // Value injected by FXMLLoader

    @FXML // fx:id="txtNumeroCualquiera"
    private TextField txtNumeroCualquiera; // Value injected by FXMLLoader

    @FXML // fx:id="txtResultadoCualquiera"
    private TextField txtResultadoCualquiera; // Value injected by FXMLLoader

    @FXML // fx:id="txtTB"
    private TextField txtTB; // Value injected by FXMLLoader

    @FXML // fx:id="txtTiB"
    private TextField txtTiB; // Value injected by FXMLLoader

    private ObservableList<Character> unidades = FXCollections.observableArrayList();
    Conversiones c = new Conversiones();

    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String contenido) {
        Alert alert = new Alert(tipo, contenido, ButtonType.CLOSE);
        alert.setTitle(titulo);
        alert.showAndWait();
    }

    void alertaNoNum() {
        mostrarAlerta(Alert.AlertType.ERROR, "ENTRADA INCORRECTA", "Tiene que ingresar un numero");
    }

    @FXML
    void convertirSI(ActionEvent event) {
        if (!c.validarNumero(txtNumeroBytesSI.getText())) {
            alertaNoNum();
        } else {
            BigDecimal bytes = new BigDecimal(txtNumeroBytesSI.getText());
            BigDecimal[] conversiones = c.convertirBytes(bytes);
            txtKB.setText(conversiones[0].toPlainString());
            txtMB.setText(conversiones[1].toPlainString());
            txtGB.setText(conversiones[2].toPlainString());
            txtTB.setText(conversiones[3].toPlainString());
        }
    }

    @FXML
    void convertirIEC(ActionEvent event) {
        if (!c.validarNumero(txtNumeroBytesIEC.getText())) {
            alertaNoNum();
        } else {
            BigDecimal bytes = new BigDecimal(txtNumeroBytesIEC.getText());
            BigDecimal[] conversiones = c.convertirBibytes(bytes);
            txtKiB.setText(conversiones[0].toPlainString());
            txtMiB.setText(conversiones[1].toPlainString());
            txtGiB.setText(conversiones[2].toPlainString());
            txtTiB.setText(conversiones[3].toPlainString());
        }
    }

    @FXML
    void convertirCualquiera(ActionEvent event) {
        if (!c.validarNumero(txtNumeroCualquiera.getText())) {
            alertaNoNum();
        } else {
            String unidadNum = chUnidadNumero.getSelectionModel().getSelectedItem();
            String unidadResultado = chUnidadResultado.getSelectionModel().getSelectedItem();
            BigDecimal num = new BigDecimal(txtNumeroCualquiera.getText());
            
            BigDecimal resultado = c.convertirDeCualquierUnidad(num, unidadNum, unidadResultado);
            txtResultadoCualquiera.setText(resultado.toPlainString());
        }
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert chUnidadNumero != null : "fx:id=\"chUnidadNumero\" was not injected: check your FXML file 'RepresentacionDatos.fxml'.";
        assert chUnidadResultado != null : "fx:id=\"chUnidadResultado\" was not injected: check your FXML file 'RepresentacionDatos.fxml'.";
        assert cmdConvertirCualquiera != null : "fx:id=\"cmdConvertirCualquiera\" was not injected: check your FXML file 'RepresentacionDatos.fxml'.";
        assert cmdConvertirIEC != null : "fx:id=\"cmdConvertirIEC\" was not injected: check your FXML file 'RepresentacionDatos.fxml'.";
        assert cmdConvertirSI != null : "fx:id=\"cmdConvertirSI\" was not injected: check your FXML file 'RepresentacionDatos.fxml'.";
        assert txtGB != null : "fx:id=\"txtGB\" was not injected: check your FXML file 'RepresentacionDatos.fxml'.";
        assert txtGiB != null : "fx:id=\"txtGiB\" was not injected: check your FXML file 'RepresentacionDatos.fxml'.";
        assert txtKB != null : "fx:id=\"txtKB\" was not injected: check your FXML file 'RepresentacionDatos.fxml'.";
        assert txtKiB != null : "fx:id=\"txtKiB\" was not injected: check your FXML file 'RepresentacionDatos.fxml'.";
        assert txtMB != null : "fx:id=\"txtMB\" was not injected: check your FXML file 'RepresentacionDatos.fxml'.";
        assert txtMiB != null : "fx:id=\"txtMiB\" was not injected: check your FXML file 'RepresentacionDatos.fxml'.";
        assert txtNumeroBytesIEC != null : "fx:id=\"txtNumeroBytesIEC\" was not injected: check your FXML file 'RepresentacionDatos.fxml'.";
        assert txtNumeroBytesSI != null : "fx:id=\"txtNumeroBytesSI\" was not injected: check your FXML file 'RepresentacionDatos.fxml'.";
        assert txtNumeroCualquiera != null : "fx:id=\"txtNumeroCualquiera\" was not injected: check your FXML file 'RepresentacionDatos.fxml'.";
        assert txtResultadoCualquiera != null : "fx:id=\"txtResultadoCualquiera\" was not injected: check your FXML file 'RepresentacionDatos.fxml'.";
        assert txtTB != null : "fx:id=\"txtTB\" was not injected: check your FXML file 'RepresentacionDatos.fxml'.";
        assert txtTiB != null : "fx:id=\"txtTiB\" was not injected: check your FXML file 'RepresentacionDatos.fxml'.";

        initChoiceBox();
        chUnidadNumero.getSelectionModel().clearAndSelect(0);
        chUnidadResultado.getSelectionModel().clearAndSelect(0);
    }

    private void initChoiceBox() {
        String[] unidades = {"bit", "kilobit", "kibibit", "megabit", "gigabit", "gibibit", "terabit", "tebibit",
            "petabit", "pebibit", "exabit", "exbibit", "zettabit", "zebibit", "yotabit", "yobibit", "byte",
            "kilobyte", "kibibyte", "megabyte", "mebibyte", "gigabyte", "gibibyte", "terabyte", "tebibyte",
            "petabyte", "pebibyte", "exabyte", "exbibyte", "zettabyte", "zebibyte", "yotabyte", "yobibyte"};
        for (int i = 0; i < unidades.length; i++) {
            chUnidadNumero.getItems().add(unidades[i]);
            chUnidadResultado.getItems().add(unidades[i]);
        }
    }
}
