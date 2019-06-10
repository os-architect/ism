import Component from '@ember/component';
import EmberObject, { computed } from '@ember/object';

export default Component.extend({

  tagName: 'td',
  classNames: ['map-tile'],
  _markedPlayerClass: 'map-tile-player',
  content: [],
  x: -1,
  y: -1,

  markPlayer: computed('content', function() {
      return this.get('player') != null;
  }),

  markContent: computed('content', function() {
      return this.get('characters').length > 0;
  })

});
