var c = document.getElementById("mainCanvas");
var ctx = c.getContext("2d");

var buttons = [
	69, 2, 69, 2, 69, 2, 69, 2,
	2, 69, 2, 69, 2, 69, 2, 69,
	69, 2, 69, 2, 69, 2, 69, 2,
	0, 69, 0, 69, 0, 69, 0, 69,
	69, 0, 69, 0, 69, 0, 69, 0,
	1, 69, 1, 69, 1, 69, 1, 69,
	69, 1, 69, 1, 69, 1, 69, 1,
	1, 69, 1, 69, 1, 69, 1, 69
];

drawBoard();
drawButtons();
	
function drawButtons() {
	index = 0;
	for (i = 0; i < 8; i++) {
		for (j = 0; j < 8; j++) {
			if (buttons[index] != 0 && buttons[index] != 69) {
				ctx.beginPath();
				ctx.arc((i * 70) + 35, (j * 70) + 35, 35, 0, 2 * Math.PI);
				ctx.fillStyle = getFillColor(buttons[index]);
				ctx.fill();
				ctx.stroke();
			}
			index++;
		}
	}
}
	
function clearCanvas() {
	ctx.clearRect(0, 0, c.width, c.height);
}

function getFillColor(number) {
	if (number == 2) {
		return '#000000';
	}
	
	return '#ffffff';
}

function drawBoard() {
	for (i = 0; i < 8; i++) {
		drawRow(i);
	}
}
	
function drawRow(counter) {
	// Draw 8 block left to right
	for (iBlockCounter = 0; iBlockCounter < 8; iBlockCounter++) {
		drawBlock(counter, iBlockCounter);
	}
}

function drawWin(text) {
	ctx.font = "40px Arial";
	// Create gradient
	var gradient=ctx.createLinearGradient(0,0,c.width,0);
	gradient.addColorStop("0","magenta");
	gradient.addColorStop("0.5","blue");
	gradient.addColorStop("1.0","red");
	// Fill with gradient
	ctx.fillStyle=gradient;
	
	ctx.fillText(text, 200, 280);
}

function drawBlock(iRowCounter, iBlockCounter) {   
	// Set the background
	ctx.fillStyle = getBlockColour(iRowCounter, iBlockCounter);
	 
	// Draw rectangle for the background
	ctx.fillRect(iRowCounter * 70, iBlockCounter * 70, 70, 70);
 
	ctx.stroke();   
}

function getBlockColour(iRowCounter, iBlockCounter) {
	var cStartColour;
	 
	// Alternate the block colour
	if(iRowCounter % 2)
		cStartColour = (iBlockCounter % 2?'#ffffff':'#9f7119');
	else
		cStartColour = (iBlockCounter % 2?'#9f7119':'#ffffff');
		 
	return cStartColour;
}