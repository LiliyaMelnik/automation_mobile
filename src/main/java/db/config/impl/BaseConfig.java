package db.config.impl;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;
import org.aeonbits.owner.Config.LoadPolicy;


@LoadPolicy(Config.LoadType.MERGE)
@Sources({"classpath:db.properties"})
public interface BaseConfig extends Config {

    String urlDB();
}
