package slavko.baze2.procesnabavke;

import javax.swing.SwingUtilities;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import slavko.baze2.procesnabavke.gui.forme.glavna.FrmGlavna;

@SpringBootApplication
public class SpringBootApp implements CommandLineRunner{
    
    private static FrmGlavna frmGlavna;

    @Bean
    public FrmGlavna appView() {
        return frmGlavna;
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            frmGlavna = new FrmGlavna();
        });
        
        SpringApplication.run(SpringBootApp.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        frmGlavna.setVisible(true);
    }

}
