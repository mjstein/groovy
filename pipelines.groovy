import java.util.Random
Random  rand = new Random()
int return_random(rand, max=10){
  return rand.nextInt(max+1) 
}


void specify_stg(String name, Closure method){
  stage name
  echo "Commencing stage ${name}"
  method()
}

Closure get_from_git(){ 
  return {git url: 'https://github.com/mjstein/chmjs-monit.git'}
}

//Start from here
node {
    test_message = "Oh Dear this hasnt worked really" 
    specify_stg('Dev' , {echo "dev"})
    
    specify_stg('Qa' , get_from_git())
    if (dotests == 'true'){
      specify_stg('Test' , {sh 'ls -a'})
    } else {

    // Call it anyway but leave empty so we keep history
      specify_stg('Test' , {echo test_message})

    }
    specify_stg('Prd' , {sh 'ls -a'})
}
