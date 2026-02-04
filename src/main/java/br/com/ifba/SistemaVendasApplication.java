package br.com.ifba;

import br.com.ifba.infrastructure.presenters.FrmProdutos;
import java.awt.EventQueue;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SistemaVendasApplication {

	public static void main(String[] args) {
            ConfigurableApplicationContext context = new SpringApplicationBuilder(SistemaVendasApplication.class)
                .headless(false)
                .run(args);

            EventQueue.invokeLater(() -> {
                FrmProdutos tela = context.getBean(FrmProdutos.class);
                tela.setVisible(true);
            });
	}
}
