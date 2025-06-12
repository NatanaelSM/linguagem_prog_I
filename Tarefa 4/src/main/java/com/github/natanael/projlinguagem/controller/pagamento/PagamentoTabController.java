package com.github.natanael.projlinguagem.controller.pagamento;

import com.github.natanael.projlinguagem.model.Pagamento;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class PagamentoTabController implements Initializable {

    public TableView<Pagamento> pagamentoTable;
    @FXML private TableColumn<Pagamento, Double> valorColumn;
    @FXML private TableColumn<Pagamento, String> formaPagamentoColumn;
    @FXML private TableColumn<Pagamento, Integer> parcelasColumn;
    @FXML private TextField valorField;
    @FXML private TextField formaPagamentoField;
    @FXML private TextField parcelasField;

    private PagamentoController pagamentoController;
    private int selectedPagamentoId = 0;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        valorColumn.setCellValueFactory(new PropertyValueFactory<>("valor"));
        formaPagamentoColumn.setCellValueFactory(new PropertyValueFactory<>("formaPagamento"));
        parcelasColumn.setCellValueFactory(new PropertyValueFactory<>("parcelas"));

        pagamentoController = new PagamentoController();

        pagamentoTable.setRowFactory(tv -> {
            TableRow<Pagamento> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty()) {
                    Pagamento p = row.getItem();
                    selectedPagamentoId = p.getId();
                    valorField.setText(String.valueOf(p.getValor()));
                    formaPagamentoField.setText(p.getFormaPagamento());
                    parcelasField.setText(String.valueOf(p.getParcelas()));
                }
            });
            return row;
        });

        carregarTabela();
    }

    public void onCadastrarPagamento(ActionEvent event) {
        double valor = Double.parseDouble(valorField.getText());
        String formaPagamento = formaPagamentoField.getText();
        int parcelas = Integer.parseInt(parcelasField.getText());

        pagamentoController.cadastrarPagamento(valor, formaPagamento, parcelas);
        limparCampos();
        carregarTabela();
    }

    public void onAtualizarPagamento(ActionEvent event) {
        Pagamento p = new Pagamento(selectedPagamentoId,
                Double.parseDouble(valorField.getText()),
                formaPagamentoField.getText(),
                Integer.parseInt(parcelasField.getText()));

        pagamentoController.atualizarPagamento(p);
        limparCampos();
        carregarTabela();
    }

    public void onDeletarPagamento(ActionEvent event) {
        pagamentoController.deletarPagamento(selectedPagamentoId);
        limparCampos();
        carregarTabela();
    }

    public void onRealizarPagamento(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);

        if (selectedPagamentoId != 0) {
            alert.setContentText("Pagamento ID " + selectedPagamentoId + " realizado com sucesso!");
        } else {
            alert.setContentText("Nenhum pagamento selecionado!");
        }

        alert.showAndWait();
    }

    public void onCancelarPagamento(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);

        if (selectedPagamentoId != 0) {
            alert.setContentText("Pagamento ID " + selectedPagamentoId + " cancelado!");
        } else {
            alert.setContentText("Nenhum pagamento selecionado!");
        }

        alert.showAndWait();
    }

    public void onExibirDetalhes(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Detalhes do Pagamento");

        if (selectedPagamentoId != 0) {
            Pagamento pagamento = pagamentoController.buscarPagamentoPorId(selectedPagamentoId);
            if (pagamento != null) {
                String detalhes = "Valor: R$ " + pagamento.getValor() +
                        "\nForma de Pagamento: " + pagamento.getFormaPagamento() +
                        "\nParcelas: " + pagamento.getParcelas();
                alert.setContentText(detalhes);
            } else {
                alert.setContentText("Pagamento não encontrado.");
            }
        } else {
            alert.setContentText("Nenhum pagamento selecionado!");
        }

        alert.showAndWait();
    }

    private void carregarTabela() {
        ObservableList<Pagamento> pagamentos = FXCollections.observableArrayList(
                pagamentoController.listarPagamentos());
        pagamentoTable.setItems(pagamentos);
    }

    private void limparCampos() {
        valorField.setText("");
        formaPagamentoField.setText("");
        parcelasField.setText("");
        selectedPagamentoId = 0;
    }

}
