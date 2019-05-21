import Route from '@ember/routing/route';
import { mod } from 'ember-math-helpers/helpers/mod';

export default Route.extend({

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
        return {
            "player": this.generatePlayer(),
            "map": this.get('map'),
            "characters": [
                this.get('enemy')
            ],
            "objects": []
        }
    },

    map: {

        "name": "Olive Land",
        "width": "10",
        "height": "10"

    },

    generatePlayer() {
        return {
             "name": "Barekiller",
             "meta": {
                 "level": "117",
                 "race": "human",
                 "sex": "male",
                 "age": "23"
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
                 "map": "anchovas",
                 "x": + Math.floor(Math.random() * 10),
                 "y": + Math.floor(Math.random() * 10)
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
        },
        "position": {
            "map": "anchovas",
            "x": + 3,
            "y": + 2
        }
    }

});
