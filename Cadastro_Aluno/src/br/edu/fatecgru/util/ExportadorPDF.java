package br.edu.fatecgru.util;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import javax.swing.*;
import java.io.FileOutputStream;

// BAIXAR ARQUIVO iText DAR BUILD PATH
public class ExportadorPDF {

    public static void exportarJTableParaPDF(JTable tabela, String caminhoPDF, String nomeAluno, String rgmAluno) {

        // Verifica se a tabela tem colunas e linhas
        if (tabela.getColumnCount() == 0 || tabela.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "A tabela está vazia! Não há dados para exportar.");
            return;
        }

        // Verifica se nome e RGM não estão vazios
        if (nomeAluno == null || nomeAluno.trim().isEmpty() || rgmAluno == null || rgmAluno.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nome ou RGM do aluno estão vazios.");
            return;
        }

        Document documento = new Document();
        try {
            PdfWriter.getInstance(documento, new FileOutputStream(caminhoPDF));
            documento.open();

            // Título com nome e RGM do aluno
            String titulo = "Boletim de " + nomeAluno + " (" + rgmAluno + ")";
            documento.add(new Paragraph(titulo, FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16)));
            documento.add(new Paragraph(" ")); // espaço em branco

            // Tabela de dados
            PdfPTable tabelaPDF = new PdfPTable(tabela.getColumnCount());
            tabelaPDF.setWidthPercentage(100);

            // Cabeçalhos
            for (int i = 0; i < tabela.getColumnCount(); i++) {
                PdfPCell cabecalho = new PdfPCell(new Phrase(tabela.getColumnName(i)));
                cabecalho.setBackgroundColor(BaseColor.LIGHT_GRAY);
                tabelaPDF.addCell(cabecalho);
            }

            // Dados das linhas
            for (int linha = 0; linha < tabela.getRowCount(); linha++) {
                for (int coluna = 0; coluna < tabela.getColumnCount(); coluna++) {
                    Object valor = tabela.getValueAt(linha, coluna);
                    tabelaPDF.addCell(valor != null ? valor.toString() : "");
                }
            }

            documento.add(tabelaPDF);
            JOptionPane.showMessageDialog(null, "PDF gerado com sucesso em: " + caminhoPDF);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao gerar PDF: " + e.getMessage());
        } finally {
            documento.close();
        }
    }
}