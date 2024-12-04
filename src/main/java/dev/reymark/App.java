package dev.reymark;


import dev.reymark.app.RootLoader;
import dev.reymark.data.MemberDAO;
import dev.sol.core.application.FXApplication;
import dev.sol.core.application.loader.FXLoaderFactory;
import dev.sol.core.registry.FXCollectionsRegister;
import dev.sol.core.registry.FXControllerRegister;
import dev.sol.core.registry.FXNodeRegister;
import dev.sol.db.DBService;
import javafx.collections.FXCollections;

/**
 * JavaFX App
 */
public class App extends FXApplication {

    public static final FXControllerRegister CONTROLLER_REGISTER = FXControllerRegister.INSTANCE;
    public static final FXCollectionsRegister COLLECTIONS_REGISTER = FXCollectionsRegister.INSTANCE;
    public static final FXNodeRegister NODE_REGISTER = FXNodeRegister.INSTANCE;

    public static final DBService DB_COOP = DBService.INSTANCE
            .initialize("jdbc:mysql://localhost/coop_dp.sql?user=root&passwords=");

    @Override
    public void initialize() throws Exception {
        setTitle("Mga Utangan");

        initialize_dataset();
        initialize_application();
    }

    private void initialize_dataset() {
        COLLECTIONS_REGISTER.register("MEMBER", FXCollections.observableArrayList(MemberDAO.getMemberList()));
    }

    private void initialize_application() {
        RootLoader rootloader = (RootLoader) FXLoaderFactory
                .createInstance(RootLoader.class, App.class.getResource("/dev/reymark/app/ROOT.fxml"))
                .addParameter("scene", applicationScene).initialize();
        rootloader.load();
    }

}