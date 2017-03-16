import { MushroomsPage } from './app.po';

describe('mushrooms App', function() {
  let page: MushroomsPage;

  beforeEach(() => {
    page = new MushroomsPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
