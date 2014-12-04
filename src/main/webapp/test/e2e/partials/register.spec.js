describe("E2E: Register User", function() {

    beforeEach(function() {
        browser().navigateTo('/');
    });

    it('register new User', function() {
        browser().navigateTo('#/register');
		
		 expect(element('.email-label').html()).toBe(
            'E-Mail'
        );

       
    });

});