var ws;
function setConnected(connected) {
	$("#connect").prop("disabled", connected);
	$("#disconnect").prop("disabled", !connected);
	if (connected) {
		$("#conversation").show();
	} else {
		$("#conversation").hide();
	}
	$("#greetings").html("");
}

function connect() {
	// connect to stomp where stomp endpoint is exposed
	var socket = new WebSocket("ws://localhost:8080/ws");
	ws = Stomp.over(socket);

	ws.connect({}, function(frame) {
		ws.subscribe("/user/queue/errors", function(message) {
			alert("Error " + message.body);
		});

		ws.subscribe("/user/queue/reply", function(message) {
			showGreeting(message.body);
		});
	}, function(error) {
		alert("STOMP error " + error);
	});
}

function disconnect() {
	if (ws != null) {
		ws.close();
	}
	setConnected(false);
	console.log("Disconnected");
}

function sendName() {
	var data = JSON.stringify({
		'name' : $("#name").val()
	})
	ws.send("/app/message", {}, data);
}

function showGreeting(message) {
	$(
			'<div class="message new">'
					+ message + '</div>').appendTo($('.mCSB_container'))
			.addClass('new');
	setDate();
	updateScrollbar();
}
var $messages = $('.messages-content'), d, h, m, i = 0;
$(function() {
	$("form").on('submit', function(e) {
		e.preventDefault();
	});
	$("#connect").click(function() {
		connect();
	});
	$("#disconnect").click(function() {
		disconnect();
	});
	

	$(window).load(function() {
		$messages.mCustomScrollbar();
		/*
		 * setTimeout(function () { //fakeMessage('Hi'); }, 100);
		 */
	});

	function insertMessage() {
		msg = $('.message-input').val();
		if ($.trim(msg) == '') {
			return false;
		}
		$('<div class="message message-personal">' + msg + '</div>').appendTo(
				$('.mCSB_container')).addClass('new');
		setDate();
		$('.message-input').val(null);
		updateScrollbar();
		setTimeout(function() {
			fakeMessage(msg);
		}, 1000 + Math.random() * 20 * 100);
	}

	$('.message-submit').click(function() {
		insertMessage();
	});

	$(window).on('keydown', function(e) {
		if (e.which == 13) {
			insertMessage();
			return false;
		}
	});


	$('.button').click(function() {
		$('.menu .items span').toggleClass('active');
		$('.menu .button').toggleClass('active');
	});
	function fakeMessage(msg) {
		if ($('.message-input').val() != '') {
			return false;
		}
		$(
				'<div class="message loading new"><span></span></div>')
				.appendTo($('.mCSB_container'));
		updateScrollbar();

		setTimeout(function() {
			$('.message.loading').remove();
			ws.send("/app/message", {}, msg);

		}, 1000 + Math.random() * 20 * 100);

	}

	
});
function updateScrollbar() {
	$messages.mCustomScrollbar("update").mCustomScrollbar('scrollTo',
			'bottom', {
				scrollInertia : 10,
				timeout : 0
			});

}

function setDate() {
	d = new Date();
	if (m != d.getMinutes()) {
		m = d.getMinutes();
		$('<div class="timestamp">' + d.getHours() + ':' + m + '</div>')
				.appendTo($('.message:last'));
		$('<div class="checkmark-sent-delivered">&check;</div>').appendTo(
				$('.message:last'));
		$('<div class="checkmark-read">&check;</div>').appendTo(
				$('.message:last'));
	}
}
