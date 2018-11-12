var clr, like_bck, f_fic, r_fic, ckrun;
var sec_bck;
var tour_img;
var open_music, open_game;
var music_div, game_div;
var new_audio;
var music_t;
var loading;


function load_func() {
  loading= document.getElementById('load_p');

  clr = document.getElementById('violet_clr');
  f_fic = document.getElementById('fantasy');
  r_fic = document.getElementById('reasoning');
  ckrun = document.getElementById('cookierun');
  sec_bck = document.getElementById('section_id');
  open_music = document.getElementById('op_m');
  open_game = document.getElementById('op_g');

  ex = document.getElementById("explan");
  like_bck = document.getElementById('like');
  t_ex = document.getElementById("tour_explan");
  id_div = document.getElementsByTagName("div");
  music_div = document.getElementById("music");
  game_div = document.getElementById("game");
  new_audio = document.getElementById("my_audio");
  music_t = document.getElementById('music_table');

  tour_img = document.getElementById('tour').getElementsByTagName('img');
  list_item = document.getElementById('contents').getElementsByTagName('li');
  ply_btn = document.getElementsByName('play_btn');
  stp_btn = document.getElementsByName('stop_btn');

loading.style.display = "none";


  now_time(1000);

  clr.onclick = chg;
  ckrun.onclick = addimg;
  f_fic.onclick = text_chg1;
  r_fic.onmouseover = ad_text;

  open_music.onclick = open_music_div;
  open_game.onclick = open_game_div;

  for (var i = 0; i < tour_img.length; i++) {
    tour_img[i].onclick = function() {
      open_ex(this.id);
    };
  }
  for (var i = 0; i < list_item.length; i++) {
    list_item[i].onclick = function() {
      // console.log(this.value);
      page(this.value);
    };
  }
  for (var i = 0; i < ply_btn.length; i++) {
    ply_btn[i].onclick = function() {
      music_play(this.value);
    };
  }
  for (var i = 0; i < stp_btn.length; i++) {
    stp_btn[i].onclick = function() {
      stop(this.value);
    };
  }
}

var id_div = new Array();
var id_li = ["intro", "like", "hobby", "tour"];

function page(num) {
  for (var j = 0; j < id_div.length; j++) {
    if (id_div[j].id == id_li[num]) {
      id_div[j].style.display = "block";
      sec_bck.style.backgroundColor = "white";
      new_audio.pause();
    } else {
      id_div[j].style.display = "none";
      if (id_div[j].id == "" || id_div[j].id == "music" || id_div[j].id == "game") {
        id_div[j].style.display = "inline-block";
      } else if (id_div[j].id == "explan" || id_div[j].id == "tour_explan" || id_div[j].id == "clock" || id_div[j].id == "h_st") {
        id_div[j].style.display = "block";
      }
    }
  }
}

function chg() {
  sec_bck.animate([{
      background: 'white'
    },
    {
      background: "#D8CEF6"
    }
  ], 1500);
  sec_bck.style.background = "#D8CEF6";
  clr.style.fontFamily = "'Hanna', sans-serif";
  like_bck.style.textShadow = "-1px 0 white, 0 1px white, 1px 0 white, 0 -1px white";
  clr.style.textShadow = "none";
  clr.style.fontWeight = "normal"
  clr.style.color = "white";
}

function text_chg1() {
  var str = f_fic.innerHTML;
  var r_str = str.replace("판타지", "Fantasy ");
  f_fic.style.fontFamily = "'Kaushan Script', cursive";
  f_fic.style.color = "#8A0808";
  f_fic.style.fontWeight = "normal"
  setInterval(text_ani(), 10);
  f_fic.innerHTML = r_str;
}

function text_ani() {
  f_fic.animate([{
      color: '#8A0808'
    },
    {
      color: '#F5A9A9'
    }
  ], 1500);
}

function addimg() {
  var count = ckrun.getElementsByTagName("img");

  ckrun.style.cursor = "pointer";
  ckrun.style.color = "#FA8258";
  ckrun.style.fontFamily = "'Jeju Gothic', sans-serif";

  if (count.length == 0) {
    ckrun.innerHTML += "<a href='https://www.cookierun.com/ko' target='_blanck'><img src='media/cookie-run-oven-break_logo.png' width= '65px' height='25px'></a>";
  }
}

var ex;
var ex_text = "";

var mX = 0;
var mY = 0;

function ad_text() {
  r_fic.style.color = "#A4A4A4";
  mX = event.clientX;
  mY = event.clientY + document.body.scrollTop;

  ex.style.left = mX + 'px';
  ex.style.top = mY + 'px';

  ex.style.visibility = "visible";
  ex.style.background = "#EFEFFB";
  // console.log(ex);
  ex_text = "<img src='media/book1.jpg' width='85px' height='105px'><img src='media/book2.jpg' width='85px' height='105px'><img src='media/book3.jpg' width='85px' height='105px'><img src='media/book4.jpg' width='85px' height='105px'>"
  ex.innerHTML = ex_text;

  r_fic.onmouseout = function() {
    ex.style.visibility = "hidden";
    r_fic.style.color = "black";
  }
}

function open_ex(tour_id) {

  t_ex.style.visibility = "visible";
  t_ex.style.background = "#F2EFFB";
  t_ex.style.borderRadius = "10px";
  // t_ex.style.color = "#088A08";
  t_ex.style.fontSize = "19.5px";
  t_ex.style.lineHeight = "23.5px";
  f_fic.style.fontFamily = "'KoPub Batang', serif";
  // console.log(ex);
  switch (tour_id) {
    case "tokyo":
      ex_text = "도쿄(東京, 토쿄, 동경)는 일본의 혼슈 동부에 있는, 메이지 시대 이후 사실상 일본의 수도이자 최대 도시이다. ";
      ex_text += "<br><img src='media/tokyo_item1.jpg' width= '65px' height='100px'> <img src='media/tokyo_item2.jpg' width= '65px' height='100px'>"

      break;
    case "osaka":
      ex_text = "오사카(大阪, Ōsaka)는 일본 긴키 지방의 지명이다. 서일본 최대의 도시인 오사카부를 가리키는 지역 명칭이며, 좁은 의미로는 오사카부의 가장 핵심지역인 오사카 시를 의미하기도 한다.";
      ex_text += "<br><img src='media/osaka_item1.jpg' width= '65px' height='100px'> <img src='media/osaka_item2.jpg' width= '65px' height='100px'>"
      break;
    case "taiwan":
      ex_text = "타이완 또는 대만(臺灣)은 동아시아에 있는 섬이다.";
      ex_text += "<br><img src='media/taiwan_item1.jpg' width= '65px' height='100px'> <img src='media/taiwan_item2.jpg' width= '65px' height='100px'>"
      break;
    case "hongkong":
      ex_text = "홍콩(香港) 혹은 중화인민공화국 홍콩 특별행정구는 중국 화난 주강 삼각강 동쪽에 위치한 자치행정구역이다. 홍콩은 마카오, 광저우, 선전, 주하이, 그리고 광둥성의 다른 주요 도시들과 함께 세계에서 가장 인구가 많은 주강 삼각주 대도시권을 형성하고 있다.";
      ex_text += "<br><img src='media/hongkong_item1.jpg' width= '65px' height='100px'> <img src='media/hongkong_item2.jpg' width= '65px' height='100px'> <img src='media/hongkong_item3.jpg' width= '65px' height='100px'>"
      break;
    default:
      break;

  }
  t_ex.innerHTML = ex_text;

  t_ex.onclick = function() {
    t_ex.style.visibility = "hidden";
  }

}


var timerID = null;

function now_time(t) {
  var page_clk = document.getElementById("clock");
  var nowtime = new Date();
  var time_H = addZeros(nowtime.getHours(), 2);
  var time_M = addZeros(nowtime.getMinutes(), 2);
  var time_S = addZeros(nowtime.getSeconds(), 2);

  page_clk.style.padding = "2px"
  page_clk.innerHTML = "<p>" + time_H + ":" + time_M + ":" + time_S + "</p>";

  setTimeout("now_time()", t);
}

function addZeros(num, digit) { // 자릿수 맞춰주기
  var zero = '';
  num = num.toString();
  if (num.length < digit) {
    for (i = 0; i < digit - num.length; i++) {
      zero += '0';
    }
  }
  return zero + num;
}

var audio_src = ["media/별빛이 피면.mp3", "media/Oh Boy.mp3", "media/VIOLET.mp3"];
var music_name;

function music_play(val) {
  alert('1분 미리듣기만 제공됩니다.');
  var start = audio_src[val].indexOf("/");
  var end = audio_src[val].indexOf(".", start + 1);
  var list = audio_src[val].substring(start + 1, end);

  for (var i = 0; i < music_t.rows.length; i++) {
    if (list == music_t.rows[i].cells[1].innerHTML) {
      music_t.rows[i].cells[1].style.border = "2px dotted #A9BCF5";
    } else {
      music_t.rows[i].cells[1].style.border = "none";
    }
  }

  new_audio.src = audio_src[val];
  new_audio.play();

  new_audio.onended = function(e) {
    music_name.style.border = "none";
  };
}

function stop(val) {
  music_name = music_t.rows[val].cells[1];
  music_name.style.border = "none";
  new_audio.pause();
}


function open_music_div() {
  music_div.style.visibility = "visible";

  open_music.onclick = function() {
    music_div.style.visibility = "hidden";
  }
}

function open_game_div() {
  game_div.style.visibility = "visible";

  open_game.onclick = function() {
    game_div.style.visibility = "hidden";
  }
}
