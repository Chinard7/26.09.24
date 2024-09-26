package view;
import javax.swing.*;
import static java.nio.file.StandardCopyOption.*;
import java.nio.file.*;
// import javax.swing.filechooser.*;

public class MoverArquivo {
    public static void main(String[] args) throws Exception {
        try {
            JFileChooser chooser = new JFileChooser();
            // chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); // esta linha ativa a opção somente pasta
            // chooser.setCurrentDirectory(new java.io.File(".")); // definir o diretório local como diretório padrão
            // chooser.setDialogTitle("Título da janela"); // esta linha define o título da tela do file chooser
            // FileNameExtensionFilter filter = new FileNameExtensionFilter(
            //         "JPG & GIF Images", "jpg", "gif"); // esta linha define o tipo de arquivo e respectivas extensões do mesmo
            // chooser.setFileFilter(filter); // esta linha aplica o filtro de tipos de arquivos a serem selecionados

            chooser.setDialogTitle("Selecione o arquivo que deseja copiar.");
            int returnVal1 = chooser.showOpenDialog(null);
            String fileFullPath = "";
            String fileName = "";
            if(returnVal1 == JFileChooser.APPROVE_OPTION) {
                System.out.println("You chose to open this file: " + chooser.getSelectedFile().getName());
                fileFullPath = chooser.getSelectedFile().getAbsolutePath();
                fileName = chooser.getSelectedFile().getName();
                System.out.println("File Full Path: " + fileFullPath);
            } else {
                System.out.println("Que pena!");
            }

            chooser.setDialogTitle("Selecione a pasta de destino.");
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int returnVal2 = chooser.showOpenDialog(null);
            String folderFullPath = "";
            if(returnVal2 == JFileChooser.APPROVE_OPTION) {
                folderFullPath = chooser.getSelectedFile().getAbsolutePath();
                System.out.println("You chose to open this folder: " + chooser.getSelectedFile().getName());
                System.out.println("Folder Full Path: " + chooser.getSelectedFile().getAbsolutePath());
            } else {
                System.out.println("Que pena!");
            }

            Path pathOrigin = Paths.get(fileFullPath);
            Path pathDestination = Paths.get(folderFullPath + "\\" + fileName);
            Files.move(pathOrigin, pathDestination, REPLACE_EXISTING);
            System.out.println("Arquivo Movido com sucesso, boa seu noia");
        } catch (Exception e) {
            System.out.println("Mover o Arquivo desejado");
        }
    }
}
