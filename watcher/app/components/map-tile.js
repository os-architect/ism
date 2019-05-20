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
      return this.get('content').length > 0 && this.get('x') == this.get('content')[0].position.x && this.get('y') == this.get('content')[0].position.y;
  }),

  markContent: computed('content', function() {
      return this.get('content').length > 0 && !this.get('markPlayer')
  })

});
