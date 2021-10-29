/*
 * Copyright 2020 - Mathilde Foglierini Perez

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */
package ch.irb.saveImages;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import javax.swing.*;

import org.apache.log4j.Logger;

import ch.irb.currentDirectory.GetSetCurrentDirectory;

import de.erichseifert.vectorgraphics2d.VectorGraphics2D;
import de.erichseifert.vectorgraphics2d.eps.EPSProcessor;
import de.erichseifert.vectorgraphics2d.svg.SVGProcessor;
import de.erichseifert.vectorgraphics2d.pdf.PDFProcessor;
import de.erichseifert.vectorgraphics2d.util.PageSize;
/**
 * @author Mathilde this class takes in argument a JPanelToExport (that has a draw(graphics2D) method) to export it in
 *         EPS format Then the image can be open with Iluustrator.
 */
public class ExportAsEPSListener implements ActionListener {
    static Logger logger = Logger.getLogger(ExportAsEPSListener.class);
    private JPanel jPanel = new JPanel();
    private GetSetCurrentDirectory getSetCurrentDir;

    public ExportAsEPSListener(JPanel jPanel, GetSetCurrentDirectory getSetCurrentDir) {
        this.jPanel = jPanel;
        this.getSetCurrentDir = getSetCurrentDir;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        final JFileChooser fileChooser = new JFileChooser() {
            public void approveSelection() {
                File f = getSelectedFile();
                if (!f.getAbsolutePath().matches(".*\\.(eps|svg|pdf)")) {
                    f = new File(f.getAbsolutePath() + ".pdf");
                }
                if (f.exists() && getDialogType() == SAVE_DIALOG) {
                    int result = JOptionPane.showConfirmDialog(this, "The file exists, overwrite?", "Existing file",
                            JOptionPane.YES_NO_CANCEL_OPTION);
                    switch (result) {
                        case JOptionPane.YES_OPTION:
                            super.approveSelection();
                            return;
                        case JOptionPane.CANCEL_OPTION:
                            cancelSelection();
                            return;
                        default:
                            return;
                    }
                }
                super.approveSelection();
            }
        };
        fileChooser.setCurrentDirectory(getSetCurrentDir.getCurrentDirectory());
        fileChooser.setDialogTitle("Save as PDF/SVG/EPS");
        int choix = fileChooser.showSaveDialog(jPanel);
        if (choix != JFileChooser.APPROVE_OPTION) {
            return;
        }
        getSetCurrentDir.setCurrentDirectory(fileChooser.getCurrentDirectory());
        File file = fileChooser.getSelectedFile();
        if (!file.getAbsolutePath().matches(".*\\.(eps|svg|pdf)")) {
            if (!file.getAbsolutePath().matches("\\.")) {
                file = new File(file.getAbsolutePath() + ".pdf");
            }
        }
        try {
            generatePSusingJava2D(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private void generatePSusingJava2D(File outputFile) throws IOException {
        String[] splitted = outputFile.getName().split("\\.");
        String extension = splitted[splitted.length - 1];
        OutputStream out = new java.io.BufferedOutputStream(new java.io.FileOutputStream(outputFile));
        try {
 
            VectorGraphics2D g2d = new VectorGraphics2D();
            jPanel.print(g2d);

            
            if (extension.equals("svg")) {
                (new SVGProcessor()).getDocument(g2d.getCommands(), new PageSize(jPanel.getWidth(), jPanel.getHeight())).writeTo(out);
            } 

            if (extension.equals("pdf")) {
                (new PDFProcessor()).getDocument(g2d.getCommands(), new PageSize(jPanel.getWidth(), jPanel.getHeight())).writeTo(out);
            } 
            
            if (extension.equals("eps")) {
                (new EPSProcessor()).getDocument(g2d.getCommands(), new PageSize(jPanel.getWidth(), jPanel.getHeight())).writeTo(out);
            }


   
        } finally {
            out.close();
        }
    }

    @SuppressWarnings("unused")
    private float cmToPixel(float cm, float dpi) {

        return (dpi / 2.54f) * cm;

    }

}
