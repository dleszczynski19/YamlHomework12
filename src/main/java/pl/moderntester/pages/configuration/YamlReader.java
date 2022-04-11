package pl.moderntester.pages.configuration;

import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.hamcrest.core.IsNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.moderntester.models.Environment;
import pl.moderntester.models.YamlFile;

import java.io.File;
import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class YamlReader {
    private static Logger log = LoggerFactory.getLogger(YamlReader.class);

    public Environment getCurrentConfig(YamlFile yamlFile, String environmentName) {
        Environment environment = yamlFile.getEnvironments().get(environmentName);
        try {
            assertThat(environment, is(IsNull.notNullValue()));
        } catch (AssertionError e) {
            log.error("Wrong environment!");
            assert false;
        }
        return environment;
    }

    public YamlFile getYamlFile() {
        YAMLMapper mapper = new YAMLMapper();
        File file = new File(java.util.Objects.requireNonNull(Thread.currentThread()
                .getContextClassLoader()
                .getResource("configTest.yaml")).getFile());
        return deserializeYaml(mapper, file);
    }

    public YamlFile deserializeYaml(YAMLMapper mapper, File file) {
        try {
            return mapper.readValue(file, YamlFile.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}