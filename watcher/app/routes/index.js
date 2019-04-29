import Route from '@ember/routing/route';

export default Route.extend({

    afterModel(model) {
        self = this;
        Ember.run.later((function() {
            self.refresh();
        }), 1000);
    },

    model() {

        function getRandomArbitrary(min, max) {
            return Math.floor(Math.random() * (max - min) + min);
        }

        self =  this;

        return {
            "name": "Barekiller",
            "meta": {
                "level": "117",
                "race": "human",
                "sex": "male",
                "age": "11872"
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
                "x": "" +  + getRandomArbitrary(0,100),
                "y": "" +  + getRandomArbitrary(0,100)
            }
        }
    }

});
