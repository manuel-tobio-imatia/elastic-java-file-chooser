/*
function getChangelogLinks() {
  File directory = new File("./changelog");
  File[] files = directory.listFiles();
  for (int i = 0; i<files.length; i++) {
     if (!files[i].isDirectory()) {
       document.write(files[i].getName());
     }
   }
}
*/

function agregar() {
  if ((navigator.appName == "Microsoft Internet Explorer") && (parseInt(navigator.appVersion) >= 4)) {
    window.external.AddFavorite(url, tituloFavoritos);
  } else {
    if (navigator.appName == "Netscape") alert("Presione Crtl+D para agregar este sitio en sus Bookmarks");
  }
}

function cambiaAURL() {
  var i, args = cambiaAURL.arguments;
  document.auxReturnValue = false;
  for (i = 0; i < (args.length - 1); i += 2) eval(args[i] + ".location='" + args[i + 1] + "'");
}

function init() {
  var isJavaValid = deployJava.versionCheck(vmin + "+");

  if (isJavaValid == false) {
    alert("Java required version is not found");
  }
}

function getWebStartLaunchIconURL() {
  var imageUrl = '//java.com/js/webstart.png';
  try {
    // for http/https; use protocol less url; use http for all other protocol
    return document.location.protocol.indexOf('http') != -1
      ? imageUrl
      : 'http:' + imageUrl;
  } catch (err) {
    return 'http:' + imageUrl;
  }
}



function getDownloadIcon(jnlp, image) {
  var is_chrome = navigator.userAgent.toLowerCase().indexOf('chrome') > -1;
  if (is_chrome) {
    document.write('<a href="' + jnlp + '" onMouseOver="window.status=\'\'; return true;"><img src="' + image + '" border="0" width="auto" min-width="30px" height="auto" /></a>');
  } else
    deployJava.createWebStartLaunchButton(jnlp, vmin);
  }

var javawsInstalled = 0;
var okvermin = false;
var mirarJWS = true;
var imposibleJWS = true;

var app = document.applets[0];
if (app != null) {
  okvermin = app.okVersion();
  mirarJWS = app.getMirarJWS();
  imposibleJWS = app.getImposibleJWS();
}

var isIE = "false";
if (navigator.mimeTypes && navigator.mimeTypes.length) {
  x = navigator.mimeTypes['application/x-java-jnlp-file'];
  if (x) javawsInstalled = 1;
} else {
  isIE = "true";
}
