module com.github.natanael.projlinguagem {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.github.natanael.projlinguagem to javafx.fxml;
    exports com.github.natanael.projlinguagem;
    opens com.github.natanael.projlinguagem.view to javafx.fxml;
}