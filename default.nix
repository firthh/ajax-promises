with
  import <nixpkgs> {};
stdenv.mkDerivation rec {
  name = "ajax-promises";
  env = buildEnv { name = name; paths = buildInputs; };

  buildInputs = [
    nodejs
  ];

  shellHook = ''
    mkdir -p .nix-node
    export NPM_CONFIG_PREFIX=$PWD/.nix-node
    export PATH=$PATH:$PWD/.nix-node/bin:$PWD/node_modules/.bin
  '';
}
