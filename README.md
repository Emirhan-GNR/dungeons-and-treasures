# 🐉 Dragons or Treasure – Java Console Adventure Game

**Dragons or Treasure** is a Java-based console adventure game where the player explores a unique, curved 7×7 map, encounters dragons, discovers traps, solves treasure puzzles, and searches for escape points.  

This project consists of two versions:  
- **DATP1 (Part 1): Single Player Version**  
- **DATP2 (Part 2): Multiplayer Version (Supports N players)**  

Both parts are designed to demonstrate logical thinking, input handling, movement systems, random generation, and method-based game design.

---

## 📌 Overview

You start on a randomly assigned tile, and each tile has rules that define where you can move.  
The world contains several **randomly generated elements**:

- 🐉 Dragons  
- 💣 Traps  
- 💰 Treasures  
- 🚪 Escape exits  
- ⚠️ Cliff exits (deadly)

Your goal is to survive, collect treasure points, avoid dragons, and escape before your treasure points drop below zero.

---

# 🎮 DATP1 – Single Player Version

In **DATP1**, only one player explores the map.

### 🌍 Gameplay Elements

- Player starts at a random coordinate.
- Dragons, traps, cliffs, and escapes spawn randomly.
- Player moves using **W A S D**.
- `canMove()` ensures valid movement depending on map shape.
- When encountering:
  - **Trap:** loses 5 points.
  - **Dragon:** loses random 0–9 points.
  - **Treasure:** must guess a 4-digit number to gain +10 points.
  - **Cliff Exit:** choosing "y" causes instant death.
  - **Escape Exit:** player can leave voluntarily.

### 🎯 End Conditions

- Treasure points drop below 0 → game ends.
- Player escapes → game ends.
- Player falls from cliff → game ends.

DATP1 is perfect for showcasing:
- Coordinate logic  
- Randomized events  
- Basic game loop  
- Scanner input handling  
- Methods and modular logic  

---

# 🎮 DATP2 – Multiplayer Version

DATP2 enhances the same concept by introducing **multiple players**, each with independent states.

### 🔢 Player Count
- User can enter any number of players.
- Arrays store:
  - Position (x_player[], y_player[])
  - Treasure points  
  - Treasure count  
  - Dragon visits  
  - Trap visits  
  - Escape/cliff status  

### 🔄 Turn-Based System
Each player takes turns in order:
- Invalid players (escaped or dead) are skipped.
- Each player moves using W/A/S/D.
- Same interactions as DATP1—dragon, trap, treasure, cliff, escape.

### 🏆 Final Statistics
When all players have either escaped or lost, the game prints:

- **Winner** → Highest treasure points  
- **Treasure Collector** → Most treasures found  
- **Dragon Briber** → Most dragon encounters  
- **Unfortunate Player** → Most traps stepped on  

DATP2 is ideal for demonstrating:
- Array logic  
- Multi-player state management  
- Turn-based iteration  
- Comparative stat evaluation  
- More advanced program structure  

---

# 💻 Technologies Used

- **Java (JDK 17+)**
- Console-based I/O (`Scanner`)
- Random generation (`Math.random`)
- Switch-case decision structures
- Arrays (DATP2)
- Method-based modular design

---

# ▶️ How to Run

### Compile:
```bash
javac DATP1.java
javac DATP2.java
