import Route from '@ember/routing/route';
import { mod } from 'ember-math-helpers/helpers/mod';

export default Route.extend({

    numCols: 30,

    afterModel(model) {
        self = this;
        Ember.run.later((function() {
            self.refresh()
        }), 1000);
    },

    getRandomArbitrary() {
                return ;
                return 5;
    },

    model() {
        console.log('Return new model')
        return {
            "player": this.generatePlayer(),
            "map": this.generateMap()
        }
    },


    generateRandomTiles() {

        var tiles = []
        var numTiles = this.get('numCols') * this.get('numCols')
        var randomTileWithEnemy = Math.floor(Math.random() * numTiles)

        for (var i=0; i<numTiles; i++){

            tiles.push({
                 "id": Math.random(),
                 "character": false,
                 "objects": [],
                 "player": false
            })

        }

        tiles[0]["character"] = this.enemy

//        tiles[randomTileWithEnemy]["character"] = this.enemy

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
                 "x": + Math.floor(Math.random() * this.get('numCols')),
                 "y": + Math.floor(Math.random() * this.get('numCols'))
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
