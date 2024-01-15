<h1>Hangman in Java</h1>
<h2>If You Download</h2>
Add res folder and main to source path<br>
<br>
<br>
<img src="https://cdn.discordapp.com/attachments/997573748297302090/1196355045881544836/image.png?ex=65b75376&is=65a4de76&hm=ad727b831401a481b5b6fe4ee43e1be216448b9f93d47d21a6831fdbe34f7a9e&">
In this program, you can have 8 saved player slots that hold the name of what the user desires. If the user choosing to make a new character, the program with prompt them to offer a new name.<br>
<img src="https://cdn.discordapp.com/attachments/997573748297302090/1196357860645408818/image.png?ex=65b75615&is=65a4e115&hm=ee6b225522fed58ecce25e0d73d018d8d1759e8d0037ecea68315068b87e03b8&">
When a player has been selected, the user is given the choice to play the game, rename the player, or delete the save slot.
<img src="https://cdn.discordapp.com/attachments/997573748297302090/1196355443505758228/image.png?ex=65b753d4&is=65a4ded4&hm=7e27d7a3d3b787ee43dca7498d40e22ba32c273e96e582396f7b585abd6763a5&">
When the user enters a game, they will be prompted to enter the hidden phrase. Once they do, the game will act like any hangman game will. Enter one letter and it will reveal any letter that is in the hidden phrase<br>
<img src="https://cdn.discordapp.com/attachments/997573748297302090/1196355958864105553/image.png?ex=65b7544f&is=65a4df4f&hm=340a61c7b957e699437aa832ff382745993cb98c888a64b84da448dd8474d4c9&">
Answer wrong and the hangman will slowly appear.<br>
<img src="https://cdn.discordapp.com/attachments/997573748297302090/1196356013801095188/image.png?ex=65b7545c&is=65a4df5c&hm=c23632139ba5b12aa63858d4b4f9854365e1965d6a9294002d5a763c059e1678&">
Whether the user loses or not, it will reveal the hidden message and prompt the user to play again, go home, or select a new player. Play again and you might encounter a new hanged man<br>
<h2>Things to improve on</h2>
During this project, I somewhat rushed since I wasn't as focused on making it the best it can be. but rather expirence I can use later.<br>
But there are mulitple things in this progam that I can change if given the right time including:<br>
<ul>
  <li>Removing repeated code and making more methods to reduce the lines of code</li>
  <li>Implementing changing colors for whether you get the letters wrong or not</li>
  <li>Add new hangamn characters</li>
  <li>Adding a win and loss counter</li>
</ul>
<h2>Learned</h2>
<ul>
  <li>Using JOptionPane</li>
  <li>Manipulating a textfile and reading it and implementing it into the program to make sudo-save files</li>
  <li>Using the CardLayout class to implement multiple panels </li>
</ul>
<h2>Known Issues</h2>
Inputing more than one character when answering the hidden phrase<br>
<li>Its a really easy fix to only accpet one character in the text field, but I originally thought and tested  that it works even if its more than one character.
  However, I believe that the main cause is when the code tries to find if the last character is included or not</li>
Window Scaling<br>
<li>Like the previous project, I can't seem to find the solution to this JFrame window scaling despite trying numerous things</li>
