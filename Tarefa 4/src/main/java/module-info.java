module com.github.natanael.projlinguagem {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires mysql.connector.j;

    opens com.github.natanael.projlinguagem to javafx.fxml;
    opens com.github.natanael.projlinguagem.controller to javafx.fxml;
    opens com.github.natanael.projlinguagem.model to javafx.base;
    exports com.github.natanael.projlinguagem;
    opens com.github.natanael.projlinguagem.controller.animal to javafx.fxml;
    opens com.github.natanael.projlinguagem.controller.carro to javafx.fxml;
    opens com.github.natanael.projlinguagem.controller.funcionario to javafx.fxml;
    opens com.github.natanael.projlinguagem.controller.pagamento to javafx.fxml;
    opens com.github.natanael.projlinguagem.controller.lutador to javafx.fxml;
}