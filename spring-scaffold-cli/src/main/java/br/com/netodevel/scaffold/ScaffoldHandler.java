package br.com.netodevel.scaffold;

import java.util.Arrays;

import joptsimple.OptionSet;
import joptsimple.OptionSpec;

import org.springframework.boot.cli.command.options.OptionHandler;
import org.springframework.boot.cli.command.status.ExitStatus;

import br.com.strategy.ControllerGenerateStrategy;
import br.com.strategy.MainGenerateStrategy;
import br.com.strategy.ModelGenerateStrategy;
import br.com.strategy.RepositoryGenerateStrategy;
import br.com.strategy.ServiceGenerateStrategy;

/**
 * @author NetoDevel
 * @since 0.0.1
 */
public class ScaffoldHandler extends OptionHandler {

	@SuppressWarnings("unused")
	private OptionSpec<String> nameEntity;

	@SuppressWarnings("unused")
	private OptionSpec<String> parametersEntity;
	
	@Override
	protected void options() {
		this.nameEntity = option(Arrays.asList("nameEntity", "n"), "Name of entity to generate scaffold").withRequiredArg();
		this.parametersEntity = option(Arrays.asList("parameterEntity", "p"), "Parameter of entity to generate scaffold").withRequiredArg();
	}
	
	@Override
	protected ExitStatus run(OptionSet options) throws Exception {
		String nameClass = (String) options.valueOf("n");
		String parametersClass = (String) options.valueOf("p");
		generateScaffold(nameClass, parametersClass);
		return ExitStatus.OK;
	}

	private void generateScaffold(String nameClass, String parametersClass) {
		new MainGenerateStrategy("");
		new ModelGenerateStrategy(nameClass, parametersClass);
		new RepositoryGenerateStrategy(nameClass);
		new ServiceGenerateStrategy(nameClass);
		new ControllerGenerateStrategy(nameClass);
	}
	
}
