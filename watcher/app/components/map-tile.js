import Component from '@ember/component';
import EmberObject, { computed } from '@ember/object';

export default Component.extend({

  tagName: 'td',
  classNames: ['map-tile'],
  _markedPlayerClass: 'map-tile-player',
  objects: [],
  character: [],
  x: -1,
  y: -1,

  markPlayer: computed('player', function() {
      return this.get('player');
  }),

  markContent: computed('character', function() {
      return this.get('character');
  })

});
