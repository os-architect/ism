import Route from '@ember/routing/route';
import { mod } from 'ember-math-helpers/helpers/mod';

export default Route.extend({

    numCols: 35,
    playerPositionX: 351,
    playerPositionY: 1102,

    actions: {

        submit: function(){},

        movenorth: function() {
        },
        movesouth: function() {
        },
        moveeast: function() {
        },
        movewest: function() {
        },
        stopmoving: function() {
        },

    },

    afterModel(model) {
        self = this;
        Ember.run.later((function() {
            self.refresh()
        }), 1000);
    },

    getRandomArbitrary() {
          return 5;
    },

    model() {
        return {
            "player": this.generatePlayer(),
            "map": this.generateMap()
        }
    },

    generateRandomTiles() {

        var tiles = [];
        var numTiles = this.get('numCols') * this.get('numCols');
        var randomTileWithEnemy = Math.floor(Math.random() * numTiles);

        var tileRealStartX = this.get('playerPositionX') - Math.floor(this.get('numCols')/2);
        var tileRealStartY = this.get('playerPositionY') - Math.floor(this.get('numCols')/2);

        for (var i=0; i<numTiles; i++){

            tiles.push({
                 "id": Math.random(),
                 "character": false,
                 "objects": [],
                 /* while backend is not ready, this is adjusted in map.js */
                 position: { /* relative to player. always an offset of numCols around the player position */
                    'x': tileRealStartX + (i % this.get('numCols')), /* needs to come from backend */
                    'y': tileRealStartY + (Math.floor(i / this.get('numCols'))) /* needs to come from backend */
                 },
                 'type': 'grass',
            })

        }

        tiles[10]["character"] = this.enemy;

        return tiles

    },

    generateMap() {
        return {
            "name": "Olive Land",
            "width": "10",
            "height": "10",
            "tiles": this.generateRandomTiles()
        }
    },

    generatePlayer() {
        return {
             "name": "Barekiller",
             "meta": {
                 "Level": "117",
                 "Race": "human",
                 "Sex": "male",
                 "Age": "23"
             },
             "skills": {
                 "sword": "17",
                 "shield": "28",
                 "acrobatics": "10"
             },
             "inventory": {
                 "Broadsword": "1",
                 "Shield": "1",
                 "Red Potion": "10"
             },
             "attributes": {
                 "STR": "87",
                 "INT": "34",
                 "DEX": "34",
                 "VIT": "34"
             },
             "position": {
                 "map": "Fort Ryo",
                 "x": + this.get('playerPositionX')/*Math.floor(Math.random() * this.get('numCols'))*/,
                 "y": + this.get('playerPositionY')/*Math.floor(Math.random() * this.get('numCols'))*/
             }
        }

    },

    enemy: {
        "name": "Green Dragon",
        "meta": {
            "level": "276",
            "race": "dragon",
            "sex": "female",
            "age": "11872"
        },
        "skills": {
            "claws": "10"
        },
        "inventory": {
        },
        "attributes": {
            "STR": "991",
            "INT": "87",
            "DEX": "49",
            "VIT": "1023"
        }
    }

});
