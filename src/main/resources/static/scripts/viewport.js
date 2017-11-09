function init() {
    var els = document.querySelectorAll('div.test');
    for (var i = 0; i < els.length; i += 1) {
        els[i].original = els[i].innerHTML;
    }

    writeWidths();
}

function writeWidths() {
    var els = document.querySelectorAll('div.test');
    for (var i = 0; i < els.length; i += 1) {
        els[i].innerHTML = '   ' + els[i].original + els[i].offsetWidth + ' px';
    }
    //      keep to reference function!!:
    // document.getElementById('layout').innerHTML = 'Layout viewport divided by 2 is ' + document.documentElement.clientWidth / 2 + ' / ' + document.documentElement.clientHeight / 2;
    // document.getElementById('visual').innerHTML = 'Visual viewport divided by 2 is ' + window.innerWidth / 2 + ' / ' + window.innerHeight / 2;
}

if (!window.onload)
    window.onload = init;

window.onscroll = window.onresize = writeWidths;

//<script type="text/javascript" src="viewport.js"></script>

// <div class="test vw">Test of <code>width: 50vw</code>.</div>
//
// <div class="test vh">Test of <code>width: 50vh</code>.</div>
//
// <div class="test vmin">Test of <code>width: 50vmin</code>.</div>
//
// <div class="test vmax">Test of <code>width: 50vmax</code>.</div>
