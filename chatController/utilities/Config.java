package chatController.utilities;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import chatController.main.Main;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

public class Config {
	public static Configuration ladeConfig() throws IOException {
		if (!Main.main.getDataFolder().exists()) {
			Main.main.getDataFolder().mkdir();
		}
		File file = new File(Main.main.getDataFolder().getPath(), "config.yml");
		if (!file.exists()) {
			file.createNewFile();
		}
		Configuration config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
		if (config.getString("Messages.ChatPrefix").equals("")) {
			config.set("Messages.ChatPrefix", "�6[�1ChatInspector�6] ");
		}
		if (config.getString("Messages.DoNotWriteThat").equals("")) {
			config.set("Messages.DoNotWriteThat", "�cYou are not allowed to write that.");
		}
		if (config.getString("Messages.WritingToFast").equals("")) {
			config.set("Messages.WritingToFast", "�cYou are writing to fast.");
		}
		if (config.getString("Messages.YouAreReapiting").equals("")) {
			config.set("Messages.YouAreReapiting", "�cYou are repeating yourself");
		}
		if (config.getList("ForbiddenWords").size() == 0) {
			List<String> liste = new ArrayList<String>();
			liste.add("Affenarsch");
			liste.add("Affenkotst�ck");
			liste.add("Affenmensch");
			liste.add("Allmachtsdackel");
			liste.add("Ameisenficker");
			liste.add("Analbaron");
			liste.add("Analraupe");
			liste.add("Analzone");
			liste.add("anorektische Fettsau");
			liste.add("Armee schwanzloser Primaten");
			liste.add("Arschbratze");
			liste.add("Arschforscher");
			liste.add("Arschfotzengesicht");
			liste.add("Arschgesicht");
			liste.add("Arschhaarbartfratze");
			liste.add("Arschkeks");
			liste.add("Arschkopf");
			liste.add("Arschlocke");
			liste.add("Atomspast");
			liste.add("Auspuffbumser");
			liste.add("Bachel");
			liste.add("Badkapp");
			liste.add("bangen");
			liste.add("Berber");
			liste.add("Birl");
			liste.add("Bl�dfisch");
			liste.add("Bl�dmusiker");
			liste.add("Bodendompteuse");
			liste.add("Brunskuh");
			liste.add("Buckelhur");
			liste.add("Bumsnuss");
			liste.add("Buschmensch");
			liste.add("Butterkuh");
			liste.add("Cholerator");
			liste.add("Dauerlutscher");
			liste.add("Dollbohrer");
			liste.add("fotze");
			liste.add("Doofmannsgehilfe");
			liste.add("Doppeldepp");
			liste.add("Dreilochnutte");
			liste.add("Du Ast!");
			liste.add("Dumm-Rasseler");
			liste.add("D�nnschissgurgler");
			liste.add("Eibemme");
			liste.add("Eichelarschkopf");
			liste.add("Fitch");
			liste.add("Flachgeist");
			liste.add("Flattermuschi");
			liste.add("Flodder");
			liste.add("Fontanellenfick");
			liste.add("Fotzklotz");
			liste.add("Gargamel");
			liste.add("Gaylon");
			liste.add("Geb�rfrau");
			liste.add("Geburtsfehlermiss");
			liste.add("geistiger Tiefflieger");
			liste.add("Gesichtseintopf");
			liste.add("Gesichtsg�nter");
			liste.add("Gesichtsmorph");
			liste.add("Gnarf");
			liste.add("Gnogel");
			liste.add("Grasdackel");
			liste.add("Gratler");
			liste.add("Gro�hirnkastrat");
			liste.add("H2O-Kopf");
			liste.add("Hack ab!");
			liste.add("Hackfresse");
			liste.add("Halbaffe");
			liste.add("Halma");
			liste.add("Hannefatzke");
			liste.add("hartzig");
			liste.add("Hausschuhgesicht");
			liste.add("HDV");
			liste.add("hirnamputierter Rhinozerusarsch");
			liste.add("Hodenbussard");
			liste.add("Hodenkopf");
			liste.add("Hodenschrubbler");
			liste.add("Hohlbratze");
			liste.add("hohle Fritte");
			liste.add("Honk");
			liste.add("Hosenlottle");
			liste.add("Hosentaschen Godzilla");
			liste.add("HRSN");
			liste.add("Huru");
			liste.add("Hutze");
			liste.add("H�bi");
			liste.add("ins Hirn schei�en");
			liste.add("Intelligenzverweigerer");
			liste.add("Kackbatzen");
			liste.add("Kackstuhl");
			liste.add("Kanisterkopf");
			liste.add("Klapskalli");
			liste.add("Klitzmorchel");
			liste.add("Klufenmichel");
			liste.add("Knallarsch");
			liste.add("Knecht Huso");
			liste.add("Kotlutscher");
			liste.add("Kotzkannenfressbrett");
			liste.add("Kotzkr�cke");
			liste.add("Krapfengesicht");
			liste.add("Kuttenluder");
			liste.add("Larve");
			liste.add("Lattenheinrich");
			liste.add("Lattenschreck");
			liste.add("L�lleb�bbl");
			liste.add("Liam");
			liste.add("Loser");
			liste.add("mangelbegent");
			liste.add("Missi");
			liste.add("Mongo");
			liste.add("Mr. Grotte");
			liste.add("Muschischeps");
			liste.add("Nafti");
			liste.add("Napfwurst");
			liste.add("Nougatnutte");
			liste.add("Nuddebumber");
			liste.add("Ogerlurch");
			liste.add("Orgasmusbremse");
			liste.add("oshig");
			liste.add("Otzenfrosch");
			liste.add("Paragrafenschubse");
			liste.add("Partyopfer");
			liste.add("Paselacke");
			liste.add("Peniskopf");
			liste.add("Penisprothesentr�ger");
			liste.add("Pfeifenheini");
			liste.add("Pferdefresse");
			liste.add("Pfingstochse");
			liste.add("pickelgesichtiger Spritzbock");
			liste.add("Pimmel");
			liste.add("Pimmelfresse");
			liste.add("Pimmelkopf");
			liste.add("Pimmelpapagei");
			liste.add("Pisskajole");
			liste.add("Plempe");
			liste.add("Pleppo");
			liste.add("Pottmolch");
			liste.add("Rotzpupsi");
			liste.add("Schlampe");
			liste.add("Schlabberlappen");
			liste.add("schleimschei�ender Bambusaffe");
			liste.add("Schmalzgrab");
			liste.add("Schmalztitte");
			liste.add("Schmongo");
			liste.add("Schm�nkchen");
			liste.add("Schmudel");
			liste.add("schnarchzapfiger R�sselsack");
			liste.add("Sch�ttler");
			liste.add("Senfgurke");
			liste.add("Sheamus");
			liste.add("Simbel");
			liste.add("Slut");
			liste.add("Spaltenspengler");
			liste.add("Spammailautor");
			liste.add("Spastard");
			liste.add("spastophil");
			liste.add("Sp�ner");
			liste.add("Spoastie");
			liste.add("Spongebob");
			liste.add("Sponk");
			liste.add("Staubbeutel");
			liste.add("Steroidbeule");
			liste.add("Steroidmutant");
			liste.add("Swarowski-M�se");
			liste.add("Tapetengerippe");
			liste.add("Topmoppel");
			liste.add("T�ffel");
			liste.add("Unwerk");
			liste.add("Vollaffe");
			liste.add("vollgepisste Strumpfhose");
			liste.add("vollgeschissene Menschenh�lle");
			liste.add("Vollmongo");
			liste.add("Vongo");
			liste.add("Wachsfresse");
			liste.add("Waldwichtel");
			liste.add("Wichsbazille");
			liste.add("Wichsfisch");
			liste.add("Wikidiot");
			liste.add("Wulfer");
			liste.add("wulffen");
			liste.add("Zahnspangenbettler");
			liste.add("zoologisches Abfallprodukt");
			liste.add("aasgeier");
			liste.add("abspritzer");
			liste.add("sdfds");
			liste.add("ackerfresse");
			liste.add("affenarsch");
			liste.add("affenhirn");
			liste.add("affenkotze");
			liste.add("afterlecker");
			liste.add("aktivex.info");
			liste.add("almosenarsch");
			liste.add("amazing");
			liste.add("am-sperma-riecher");
			liste.add("anal");
			liste.add("analadmiral");
			liste.add("analbesamer");
			liste.add("analbohrer");
			liste.add("analdrill");
			liste.add("analentjungferer");
			liste.add("analerotiker");
			liste.add("analfetischist");
			liste.add("analf�rster");
			liste.add("anal-frosch");
			liste.add("analnegerdildo");
			liste.add("analratte");
			liste.add("analritter");
			liste.add("aok-chopper");
			liste.add("armleuchter");
			liste.add("arsch");
			liste.add("arschaufrei�er");
			liste.add("arschbackensch�nder");
			liste.add("arschbesamer");
			liste.add("�rsche");
			liste.add("arschentjungferer");
			liste.add("arschficker");
			liste.add("arschgeburt");
			liste.add("arschgeige");
			liste.add("arschgesicht");
			liste.add("arschhaarfetischist");
			liste.add("arschhaarrasierer");
			liste.add("arschh�hlenforscher");
			liste.add("arschkrampe");
			liste.add("arschkratzer");
			liste.add("arschlecker");
			liste.add("arschloch");
			liste.add("arschl�cher");
			liste.add("arschmade");
			liste.add("arschratte");
			liste.add("arschzapfen");
			liste.add("arsebandit");
			liste.add("arsehole");
			liste.add("arsejockey");
			liste.add("arselicker");
			liste.add("arsenuts");
			liste.add("arsewipe");
			liste.add("assel");
			liste.add("assfuck");
			liste.add("assfucking");
			liste.add("assgrabber");
			liste.add("asshol");
			liste.add("asshole");
			liste.add("asshole");
			liste.add("assi");
			liste.add("assrammer");
			liste.add("assreamer");
			liste.add("asswipe");
			liste.add("astlochficker");
			liste.add("auspufflutscher");
			liste.add("bad motherfucker");
			liste.add("badass");
			liste.add("badenutte");
			liste.add("bananenstecker");
			liste.add("bastard");
			liste.add("bastard");
			liste.add("bauernschlampe");
			liste.add("beating the meat");
			liste.add("beef curtains");
			liste.add("beef flaps");
			liste.add("behindis");
			liste.add("bekloppter");
			liste.add("muttergeficktes");
			liste.add("beklopter");
			liste.add("bettn�sser");
			liste.add("bettpisser");
			liste.add("bettspaltenficker");
			liste.add("biatch");
			liste.add("bimbo");
			liste.add("bitch");
			liste.add("bitches");
			liste.add("bitchnutte");
			liste.add("bitsch");
			liste.add("bizzach");
			liste.add("bl�dmann");
			liste.add("blogspoint");
			liste.add("blow job");
			liste.add("bohnenfresser");
			liste.add("boob");
			liste.add("boobes");
			liste.add("boobie");
			liste.add("boobies");
			liste.add("boobs");
			liste.add("booby");
			liste.add("boy love");
			liste.add("breasts");
			liste.add("brechfurz");
			liste.add("b�ckfleisch");
			liste.add("b�ckst�ck");
			liste.add("b�ckvieh");
			liste.add("buggery");
			liste.add("bullensohn");
			liste.add("bummsen");
			liste.add("bumsen");
			liste.add("bumsklumpen");
			liste.add("buschnutte");
			liste.add("busty");
			liste.add("butt pirate");
			liste.add("buttfuc");
			liste.add("buttfuck");
			liste.add("buttfucker");
			liste.add("buttfucking");
			liste.add("carpet muncher");
			liste.add("carpet munchers");
			liste.add("carpetlicker");
			liste.add("carpetlickers");
			liste.add("chausohn");
			liste.add("clitsuck");
			liste.add("clitsucker");
			liste.add("clitsucking");
			liste.add("cock");
			liste.add("cock sucker");
			liste.add("cockpouch");
			liste.add("cracka");
			liste.add("crap");
			liste.add("craper");
			liste.add("crapers");
			liste.add("crapping");
			liste.add("craps");
			liste.add("cunt");
			liste.add("cunt");
			liste.add("cunts");
			liste.add("dachlattengesicht");
			liste.add("dackelficker");
			liste.add("dickhead");
			liste.add("dicklicker");
			liste.add("diplomarschloch");
			liste.add("doofi");
			liste.add("douglette");
			liste.add("drecksack");
			liste.add("drecksau");
			liste.add("dreckschlitz");
			liste.add("drecksch�ppengesicht");
			liste.add("drecksm�sendagmar");
			liste.add("drecksnigger");
			liste.add("drecksnutte");
			liste.add("dreckspack");
			liste.add("dreckst�rke");
			liste.add("dreckvotze");
			liste.add("dumbo");
			liste.add("dummschw�tzer");
			liste.add("dumpfbacke");
			liste.add("d�nnpfifftrinker");
			liste.add("eichellecker");
			liste.add("eierkopf");
			liste.add("eierlutscher");
			liste.add("eisw�rfelpisser");
			liste.add("ejaculate");
			liste.add("entenfisterer");
			liste.add("epilepi");
			liste.add("epilepis");
			liste.add("epileppis");
			liste.add("fagette");
			liste.add("fagitt");
			liste.add("f�kalerotiker");
			liste.add("faltenficker");
			liste.add("fatass");
			liste.add("ferkelficker");
			liste.add("ferkel-ficker");
			liste.add("fettarsch");
			liste.add("fettsack");
			liste.add("fettsau");
			liste.add("feuchtwichser");
			liste.add("fick");
			liste.add("fick*");
			liste.add("fickarsch");
			liste.add("fickdreck");
			liste.add("ficken");
			liste.add("ficker");
			liste.add("fickfehler");
			liste.add("fickfetzen");
			liste.add("fickfresse");
			liste.add("fickfrosch");
			liste.add("fickfucker");
			liste.add("fickgelegenheit");
			liste.add("fickgesicht");
			liste.add("fickmatratze");
			liste.add("ficknudel");
			liste.add("ficksau");
			liste.add("fickschlitz");
			liste.add("fickschnitte");
			liste.add("fickschnitzel");
			liste.add("fingerfuck");
			liste.add("fingerfucking");
			liste.add("fisch-stinkender hodenfresser");
			liste.add("fistfuck");
			liste.add("fistfucking");
			liste.add("flachtitte");
			liste.add("fotze");
			liste.add("fotzhobel");
			liste.add("fris�senficker");
			liste.add("fritzfink");
			liste.add("fucked");
			liste.add("fucker");
			liste.add("fucker");
			liste.add("fucking");
			liste.add("fuckup");
			liste.add("fudgepacker");
			liste.add("futtgesicht");
			liste.add("gay lord");
			liste.add("geilriemen");
			liste.add("gesichtsfotze");
			liste.add("g�ring");
			liste.add("gro�maul");
			liste.add("gummifotzenficker");
			liste.add("gummipuppenbumser");
			liste.add("gummisklave");
			liste.add("hackfresse");
			liste.add("hafensau");
			liste.add("hartgeldhure");
			liste.add("heil hitler");
			liste.add("hi hoper");
			liste.add("hinterlader");
			liste.add("hirni");
			liste.add("hitler");
			liste.add("hodenbei�er");
			liste.add("hodensohn");
			liste.add("homo");
			liste.add("hosenpisser");
			liste.add("hosenschei�er");
			liste.add("h�hnerficker");
			liste.add("huhrensohn");
			liste.add("hundeficker");
			liste.add("hundesohn");
			liste.add("hurenlecker");
			liste.add("hurenpeter");
			liste.add("hurensohn");
			liste.add("hurentocher");
			liste.add("idiot");
			liste.add("idioten");
			liste.add("itakker");
			liste.add("ittaker");
			liste.add("jack off");
			liste.add("jackass");
			liste.add("jackshit");
			liste.add("jerk off");
			liste.add("jizz");
			liste.add("judensau");
			liste.add("kackarsch");
			liste.add("kacke");
			liste.add("kacken");
			liste.add("kackfass");
			liste.add("kackfresse");
			liste.add("kacknoob");
			liste.add("kaktusficker");
			liste.add("kanacke");
			liste.add("kanake");
			liste.add("kanaken");
			liste.add("kanaldeckelbefruchter");
			liste.add("kartoffelficker");
			liste.add("kinderficken");
			liste.add("kinderficker");
			liste.add("kinderporno");
			liste.add("kitzler fresser");
			liste.add("klapposkop");
			liste.add("klolecker");
			liste.add("kl�tenlutscher");
			liste.add("knoblauchfresser");
			liste.add("konzentrationslager");
			liste.add("kotgeburt");
			liste.add("kotnascher");
			liste.add("k�mmelt�rke");
			liste.add("k�mmelt�rken");
			liste.add("lackaffe");
			liste.add("lebensunwert");
			liste.add("lesbian");
			liste.add("lurchi");
			liste.add("lustbolzen");
			liste.add("lutscher");
			liste.add("magerschwanz");
			liste.add("manwhore");
			liste.add("masturbate");
			liste.add("meat puppet");
			liste.add("missgeburt");
			liste.add("mi�geburt");
			liste.add("mistsau");
			liste.add("mistst�ck");
			liste.add("mitternachtsficker");
			liste.add("mohrenkopf");
			liste.add("mokkast�bchenveredler");
			liste.add("mongo");
			liste.add("m�se");
			liste.add("m�senficker");
			liste.add("m�senlecker");
			liste.add("m�senputzer");
			liste.add("m�ter");
			liste.add("mother fucker");
			liste.add("mother fucking");
			liste.add("motherfucker");
			liste.add("muschilecker");
			liste.add("muschischlitz");
			liste.add("mutterficker");
			liste.add("nazi");
			liste.add("nazis");
			liste.add("neger");
			liste.add("nigga");
			liste.add("nigger");
			liste.add("niggerlover");
			liste.add("niggers");
			liste.add("niggerschlampe");
			liste.add("nignog");
			liste.add("nippelsauger");
			liste.add("nutte");
			liste.add("nuttensohn");
			liste.add("nuttenstecher");
			liste.add("nuttentochter");
			liste.add("ochsenpimmel");
			liste.add("�lauge");
			liste.add("oral sex");
			liste.add("penis licker");
			liste.add("penis licking");
			liste.add("penis sucker");
			liste.add("penis sucking");
			liste.add("penis");
			liste.add("peniskopf");
			liste.add("penislecker");
			liste.add("penislutscher");
			liste.add("penissalat");
			liste.add("penner");
			liste.add("pferdearsch");
			liste.add("phentermine");
			liste.add("pimmel");
			liste.add("pimmelkopf");
			liste.add("pimmellutscher");
			liste.add("pimmelpirat");
			liste.add("pimmelprinz");
			liste.add("pimmelschimmel");
			liste.add("pimmelvinni");
			liste.add("pindick");
			liste.add("piss off");
			liste.add("piss");
			liste.add("pissbirne");
			liste.add("pissbotte");
			liste.add("pisse");
			liste.add("pisser");
			liste.add("pissetrinker");
			liste.add("pissfisch");
			liste.add("pissflitsche");
			liste.add("pissnelke");
			liste.add("polacke");
			liste.add("polacken");
			liste.add("poop");
			liste.add("popellfresser");
			liste.add("popostecker");
			liste.add("popunterlage");
			liste.add("porn");
			liste.add("porno");
			liste.add("pornografie");
			liste.add("pornoprengel");
			liste.add("pottsau");
			liste.add("pr�rieficker");
			liste.add("prick");
			liste.add("quiff");
			liste.add("randsteinwichser");
			liste.add("rasierte votzen");
			liste.add("rimjob");
			liste.add("rindsriemen");
			liste.add("ritzenfummler");
			liste.add("rollbrooden");
			liste.add("roseten putzer");
			liste.add("roseten schlemmer");
			liste.add("rosettenhengst");
			liste.add("rosettenk�nig");
			liste.add("rosettenlecker");
			liste.add("rosettentester");
			liste.add("sackfalter");
			liste.add("sackgesicht");
			liste.add("sacklutscher");
			liste.add("sackratte");
			liste.add("saftarsch");
			liste.add("sakfalter");
			liste.add("schamhaarlecker");
			liste.add("schamhaarsch�del");
			liste.add("schandmaul");
			liste.add("scheisse");
			liste.add("scheisser");
			liste.add("scheissgesicht");
			liste.add("scheisshaufen");
			liste.add("schei�haufen");
			liste.add("schlammfotze");
			liste.add("schlampe");
			liste.add("schleimm�se");
			liste.add("schlitzpisser");
			liste.add("schmalspurficker");
			liste.add("schmeue");
			liste.add("schmuckbert");
			liste.add("schnuddelfresser");
			liste.add("schnurbeltatz");
			liste.add("schrumpelfotze");
			liste.add("schwanzlurch");
			liste.add("schwanzlutscher");
			liste.add("schweinepriester");
			liste.add("schweineschwanzlutscher");
			liste.add("schwuchtel");
			liste.add("schwutte");
			liste.add("shiter");
			liste.add("shiting");
			liste.add("shitlist");
			liste.add("shitomatic");
			liste.add("shits");
			liste.add("shitty");
			liste.add("shlong");
			liste.add("shut the fuckup");
			liste.add("sieg heil");
			liste.add("sitzpisser");
			liste.add("skullfuck");
			liste.add("skullfucker");
			liste.add("skullfucking");
			liste.add("slut");
			liste.add("smegmafresser");
			liste.add("spack");
			liste.add("spacko");
			liste.add("spaghettifresser");
			liste.add("spastard");
			liste.add("spasti");
			liste.add("spastis");
			liste.add("spermafresse");
			liste.add("spermarutsche");
			liste.add("spritzer");
			liste.add("stinkschlitz");
			liste.add("stricher");
			liste.add("suck my cock");
			liste.add("suck my dick");
			liste.add("threesome");
			liste.add("tittenficker");
			liste.add("tittenspritzer");
			liste.add("titties");
			liste.add("titty");
			liste.add("tunte");
			liste.add("untermensch");
			liste.add("vagina");
			liste.add("vergasen");
			liste.add("viagra");
			liste.add("volldepp");
			liste.add("volldeppen");
			liste.add("vollhorst");
			liste.add("vollidiot");
			liste.add("vollpfosten");
			liste.add("vollspack");
			liste.add("vollspacken");
			liste.add("vollspasti");
			liste.add("vorhaut");
			liste.add("votze");
			liste.add("votzenkopf");
			liste.add("wanker");
			liste.add("wankers");
			liste.add("weichei");
			liste.add("whoar");
			liste.add("whore");
			liste.add("wichsbart");
			liste.add("wichsbirne");
			liste.add("wichser");
			liste.add("wichsfrosch");
			liste.add("wichsgriffel");
			liste.add("wichsvorlage");
			liste.add("wickspickel");
			liste.add("wixa");
			liste.add("wixen");
			liste.add("wixer");
			liste.add("wixxer");
			liste.add("wixxxer");
			liste.add("wixxxxer");
			liste.add("wurstsemmelfresser");
			liste.add("yankee");
			liste.add("zappler");
			liste.add("zyclon");
			liste.add("zyklon");

			config.set("ForbiddenWords", liste);
		}
		ConfigurationProvider.getProvider(YamlConfiguration.class).save(config, file);
		return config;
	}
}
