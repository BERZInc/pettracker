function getCookie(cname) {
    let name = cname + "=";
    let ca = document.cookie.split(';');
    for(let i = 0; i < ca.length; i++) {
        let c = ca[i];
        while (c.charAt(0) == ' ') {
        c = c.substring(1);
        }
        if (c.indexOf(name) == 0) {
        return c.substring(name.length, c.length);
        }
    }
    return "";
}

function setCookie(cname,cvalue,exdays) {
    const d = new Date();
    d.setTime(d.getTime() + (exdays*24*60*60*1000));
    let expires = "expires=" + d.toUTCString();
    document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
}

function setCookieByDate(cname,cvalue,date) {
    const d = new Date(date);
    let expires = "expires=" + d.toUTCString();
    document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
}


function getCookieAndValidate(cname) {
    let cookie = getCookie(cname);
    if (cookie != "") {
        return cookie;
    } else {
        window.location.replace("home.html");
    }
}

$(function () {
    
    $("#logout").on("click", function(e) {
        setCookie("token", "", -1);
        window.location.replace("home.html");
    });


});
