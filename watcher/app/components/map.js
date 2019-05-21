import Component from '@ember/component';
import EmberObject, { computed } from '@ember/object';

export default Component.extend({
    classNames: ["map"],

    tiles: computed('player', function() {
        return this.createTiles()
    }),

    createTiles() {
        this._super();
        var i = 0;
        var rows = 10;
        var cols = 10;
        var isInThisCell = false;
        var x = this.get('player').position.x;
        var y = this.get('player').position.y;
        var tiles = []
        var subarray = [];
        var content = [];

        for(i = 1; i<(rows*cols)+1; i++){

            isInThisCell = ((y * cols) + x ) == i - 1

            // TODO SCAN FOR OTHER CHARACTERS TOO!!!!
            // ADD THEM HERE SO THAT THE TILES CAN BE COLORED ACCORDINGLY

            subarray.push({"content": {
                "player": isInThisCell ? [this.get('player')] : {},

            }})

            if(i != 0 && i % 10 == 0){
              tiles.push(subarray)
              subarray = []
            }

        }

        return tiles;

    }

});


//col:          0     1     2     3     4     5     6     7     8     9
//row: 0        0,0   1,0   2,0   3,0   4,0   0,5   0,6   0,7   0,8   0,9
//
//     1        1,0   1,1   1,2   1,3   4,1   1,5   1,6   1,7   1,8   1,9
