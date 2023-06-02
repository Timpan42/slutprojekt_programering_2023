[
## info
Figma skiss: https://www.figma.com/file/8ZKrw4c9AARgrZiZ94sVRn/Untitled?node-id=2%3A84&t=q5vRXNLk3nrzcBOW-1

![Alt text](gui_design.png)

Nätverkskoppling:  
En av spelaren få starta servern så andra kan joina den personens ip.
För att spela måste man vara en client.client.
Clientetn skicka info till servern som uppdaterar brädan.
Alla kan se brädan på sin skärm som uppdateras av servern.

En guide på hur man gör grid spel:
https://www.youtube.com/playlist?list=PLgLT8uqXESN-oVsv9PA4NtcTiqjk4Z4g7

Används för att göra GUI.

## Ska göra
### Servern 
- ska börja med den
- serverns GUI
- Göra knappar 
- Kan clienter gå med servern 
- kan det skicka info till servern
- kan servern skicka info till clienterna. 

### Client
- healTimer ska kopplas till en timmer som är beroende på rundan.
- Om man får röra på sig, så man inte går ut ur kartan eller igenom en annan spelare.
- Om man får skjuta, finns det någon nära nog eller missar man.
- Om man blev skjuten eller inte 

# log
## vecka 17
### Torsdag
Skrev readme 

### Fredag
Skrev klart readme och gjorde klass diagram 

## vecka 18
### Torsdag
Utveklade klass diagram och började med att göra all info till client.tank.
Gjorde också clientet där moment logiken har börjas men inte testat.

### Fredag
Fixade stora delar av clienten och utökade den med info jag tror kommer att behövas.
Gjorde så man kan heala, skjuta, om man blir skjuten och om man dör. 
Utökade med mer info i client.tank som kan behövas. 
Hittade en guide som kommer att användas för att göra GUI för spelet. 

## vecka 19
### Torsdag
Så jag försökte jobba med grid templated som jag länkade till.
Dock gick det väldigt dåligt att använda efter att importera den.
Den hade massa errors och den körde ändå men om man fick bord errorna så sluta den funka.
Så jag tror det är bättre att göra en från början eller gamla projekt.
### Fredag
Sjuk denna dag 

## vecka 21
### Torsdag
Jag har gjort en server.server och client.client som kan skicka info i mella dem
Har börjat att koppla ihop alla delar med varandra.
Behöver ändra i client.draw filen så controllen kan använda och ändra på informationen 

### Fredag
Har gjort en ActionListener till knapparna
samt en funktion som ska updatera brädan 
så spelaren rör på sig. Funkar inte riktigt 

## vecka 22
### Torsdag
Fixade så att clienten kan skicka info till servern
och sen kan servern skicka info till clienten.
Nu behöves bara rätt info skickas mellan varandra och den ska användas.

### Fredag
PM dagen 
