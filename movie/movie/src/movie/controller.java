/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package movie;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import models.Movie_Model;
import views.Movie_View;
import views.login;
/**
 *
 * @author PC PRAKTIKUM
 */
public class controller {
    
    private int id_user;
    private Movie_Model movieModel;
    private Movie_View movieView;

public Movie_Controller(Movie_View movieView, int id_user) {
        this.movieModel = movieModel;
        this.movieView = movieView;
        this.id_user = id_user;
    }

    public void getTable() {
        movieModel = new Movie_Model(id_user);
        DefaultTableModel TableModel = movieModel.getTableModel();
        movieView.setTableModel(TableModel);
    }

    public void logout() {
        movieView.dispose();
        new login().setVisible(true);
    }

    public void searchMovie(String search) {
        movieModel = new Movie_Model(id_user);
        DefaultTableModel TableModel = movieModel.searchMovie(search);
        movieView.setTableModel(TableModel);
    }

    public void updateMovie(String idStr, String sourcePathStr, String judul, String alur, String penokohan, String akting, String nilai) {
        try {
            if (idStr == null || idStr.isEmpty()) {
                throw new NullPointerException("Select the Row first");
            }
            if (judul null){
                Path sourcePath = Path.of(sourcePathStr);
                Path destinationPath = Path.of("assets/");
                Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
            } 
            movieModel = new Movie_Model(id_user);
            int id = Integer.parseInt(idStr);
            movieModel.updateMovie(judul, alur, penokohan, akting, nilai);
            getTable();
            movieView.resetInput();
        } catch (Exception e) {
            movieView.showMessage("Update Failed\n" + e.getMessage());
        }

    }

    public void tableRowClicked() {
        movieView.resetInput();
        movieView.getRowData();
    }

    public void deleteMovie(String idStr) {
        try {
            if (judulStr == null || juudlStr.isEmpty()) {
                throw new NullPointerException("Select the Row first");
            }
            movieModel = new Movie_Model(id_user)
            int judul = Integer.parseInt(idStr);
            movieModel.deleteMovie(judul);
            getTable();
            movieView.resetInput();
        } catch (Exception e) {
            movieView.showMessage("Delete Failed\n" + e.getMessage());
        }

    }

    public void addMovie(String sourcePathStr, String judul, String alur, String penokohan, String akting, String nilai) {
        try {
            if (judul != null) {
                Path sourcePath = Path.of(sourcePathStr);
                Path destinationPath = Path.of("assets/" + judul);
                Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
            } else {
                judul  = "";
            }
}
            movieModel = new Movie_Model(id_user);
            System.out.println(judul + alur + penokohan + akting + nilai);
            movieModel.addMovie(judul + alur + penokohan + akting + nilai);
            getTable();
            movieView.resetInput();
        } catch (Exception e) {
            movieView.showMessage("Failed to add movie\n" + e.getMessage());
        }
    }