package test;

import model.KFet;

import tools.ImageLoader;
import view.KFrame;

public abstract class Test {
    public static void main(String[] args) {
	loadInRam();

	KFet.getInstance().getStock().loadFromXml();

	KFrame test = new KFrame();
	test.setVisible(true);
    }

    public static void loadInRam() {
	ImageLoader buttons = ImageLoader.newImageLoader("buttons");
	buttons.addPath("img1", "./image/bouton1.png");
	buttons.addPath("menu_croq", "./image/menu_croq.gif");
	buttons.addPath("menu_hotdog", "./image/menu_hotdog.gif");
	buttons.addPath("menu_nouille", "./image/menu_nouille.gif");
	buttons.addPath("menu_salade", "./image/menu_salade.gif");
	buttons.addPath("plat_1croq", "./image/1croq.gif");
	buttons.addPath("plat_boisson", "./image/boisson.gif");
	buttons.addPath("plat_cafe", "./image/cafe.gif");
	buttons.addPath("plat_hotdog", "./image/hotdog.gif");
	buttons.addPath("plat_nouille", "./image/nouille.gif");
	buttons.addPath("plat_salade", "./image/salade.gif");
	buttons.addPath("plat_dessert", "./image/dessert.gif");
	buttons.loadImages();

	ImageLoader global = ImageLoader.newImageLoader("global");
	global.addPath("logo", "./image/logo.png");
	global.addPath("sync", "./image/synchronize.jpg");
	global.addPath("print", "./image/print.png");
	global.addPath("help", "./image/help.png");
	global.addPath("commande", "./image/commande.png");
	global.addPath("stock", "./image/stock.png");
	global.addPath("tresorerie", "./image/tresorerie.png");
	global.addPath("achatvente", "./image/achatvente.png");
	global.addPath("flecheup", "./image/fleche-up.png");
	global.addPath("flechedown", "./image/fleche-down.png");
	global.loadImages();
    }
}
